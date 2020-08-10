# JCF结构

简介:java集合框架系列.

API:java.util.*

* Collection[I]
  * List[I] - 有序可重复
    * **ArrayList[C]**  - 底层的数据结构:动态增长的数组
    * LinkedList[C] - 重点掌握,底层的数据结构 - 双向链表.
    * Vector[C]
  * Set[I] - 无序不可重复
    * **HashSet[C]** - 哈希表,底层就是HashMap
    * SortedSet[I]
      * TreeSet[C] - 不可重复但是可以排序.

* Map[I]
  * **HashMap[C]** - JDK8.x 桶数组 + 链表 + ***红黑树***
  * Hashtable[C] - 哈希表
    * Properties[C] - 属性类



# ArrayList扩容机制

~~~java
List<String> list = new ArrayList<>();
list.add("ok");//研究add方法的底层.
list.add("good");
~~~

java.util.ArrayList底层是"动态增长"的***数组***.

~~~java
 /**
     * 默认数组的初始化的容量.
     */
private static final int DEFAULT_CAPACITY = 10;

//默认是一个长度为0的数组.
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

//本质是用来保存集合中添加进去的数据的.
transient Object[] elementData;

 /**
     * The size of the ArrayList (the number of elements it contains).
     *
     * @serial
     */
private int size;//有效数量
~~~

List<String> list = new ArrayList<>();

~~~java
public ArrayList() {
  this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
调用完空参构造之后,得出一个结论: this.elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA - true
~~~

研究add方法

~~~java
 public boolean add(E e) {
   	    //第一次进来,size = 0;
   	   //第二次进来,参数 - 2
        ensureCapacityInternal(size + 1);  // 扩容方法...
        elementData[size++] = e;
        return true;
    }
~~~

~~~java
//第一次进来minCapacity = 1
private void ensureCapacityInternal(int minCapacity) {
  		  //第一次肯定判断为true
  
        //第二次进来不走,因为第一次走完的时候elementData已经指向另外一个新的长度为10的新数组了.
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            //第一次进来minCapacity = 10
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

  		  //second - minCapacity - 2
        ensureExplicitCapacity(minCapacity);//10
    }
~~~

~~~java
private void ensureExplicitCapacity(int minCapacity) {
        modCount++;//暂时不用关心,非安全删除的时候

        // overflow-conscious code
  			//10 - 0
  
       //second - 2
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);//扩容操作.
    }
~~~

真正的扩容操作

~~~java
 private void grow(int minCapacity) {//第一次进来
        //第一次进来
        //oldCapacity = 0
        int oldCapacity = elementData.length;
        //newCapacity = 0
        int newCapacity = oldCapacity + (oldCapacity >> 1);//按照1.5倍进行扩容...
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;//newCapacity = 10
        if (newCapacity - MAX_ARRAY_SIZE > 0)//限制集合中元素的个数.到达极限
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
   
   		  //第一次进来elementData = Arrays.copyOf(elementData,10);
   			//只要第一次调用add方法之后,elementData已经指向一个长度为10的新的数组了.
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
~~~



# 迭代器

~~~java
Iterator<Integer> iter = list.iterator();
while(iter.hasNext()){
  Integer n = iter.next();
  System.out.println(n);
}
~~~

为什么集合中提供了一种特有的迭代方式 - 迭代器呢?

~~~java
因为这些集合容器的底层数据结构是不一样的,不同的数据结构查询的方式应该是不一样的.
既然不一样,那么就有必要去提供一个统一的方式来迭代不同数据结构的集合容器.
  
比如:ArrayList.java
  private class Itr implements Iterator<E> {
    int cursor;       // index of next element to return
    int lastRet = -1; // index of last element returned; -1 if no such
    int expectedModCount = modCount;

~~~



# 集合的删除注意点

~~~java
 /**
     * 非安全删除...
     * 增强for循环是一个只读的循环.
     * 禁止在遍历集合的同时,再去进行删除操作.
     * 如果执行了这个操作,它会抛出一个并发修改的异常....
     * @param list
     * @param bookName
     */
    private static void unSafeDel(List<Book> list,String bookName){
        for (Book book : list) {
            if(book.getBookName().equals(bookName)){
                list.remove(book);//直接删除对象...
            }
        }
    }
抛出一个并发修改的异常 - Exception in thread "main" java.util.ConcurrentModificationException
~~~

结论1 - 集合中使用增强for循环来进行遍历的时候,增强for循环的遍历的底层实际上还是使用迭代器.



如何做到"只读"的效果...

~~~java
public E next() {
  checkForComodification();//异常报错行...
  int i = cursor;
  if (i >= size)
    throw new NoSuchElementException();
  Object[] elementData = ArrayList.this.elementData;
  if (i >= elementData.length)
    throw new ConcurrentModificationException();
  cursor = i + 1;
  return (E) elementData[lastRet = i];
}

 final void checkForComodification() {
   if (modCount != expectedModCount)
     throw new ConcurrentModificationException();//并发修改异常...
 }
~~~

* 定位到add方法

  每次执行add方法的时候,**modCount**都会自增1...

  ~~~java
   protected transient int modCount = 0;
   
  private void ensureExplicitCapacity(int minCapacity) {
          modCount++;
  
          // overflow-conscious code
          if (minCapacity - elementData.length > 0)
              grow(minCapacity);
      }
  ~~~

* 定位到remove方法

  底层也实现了**modCount**++的一个自增..

  ~~~java
  private void fastRemove(int index) {
          modCount++;
          int numMoved = size - index - 1;
          if (numMoved > 0)
              System.arraycopy(elementData, index+1, elementData, index,
                               numMoved);
          elementData[--size] = null; // clear to let GC do its work
      }
  
  ~~~

* 研究迭代器迭代方法

  ~~~java
   private class Itr implements Iterator<E> {
          int cursor;       // index of next element to return
          int lastRet = -1; // index of last element returned; -1 if no such
          int expectedModCount = modCount;
     
     			//此时此刻modCount的值应该是多少?
          //添加add方法之后,但是在调用remove方法之前的值.
     
          //只要在迭代的过程中,出现了remove语句,那么exexpectedModCount!=modCount
   }
  ~~~

  

# LinkedList

简介:底层的数据结构,jdk6.x是采用的是双向循环链表.j**dk8.x采用的是双向链表.**

***优势就是在增删效率比较高(只会涉及到相邻节点),但是查询效率会比较慢[底层进行了优化,采用的是二分搜索法]***



**应用场景:特别适合解决队列(先进先出)和栈列(先进后出)的业务场景** - 贪吃蛇.



单向链表.

每个节点中拥有element[集合中保存的真正的元素]以及next(指向下一个节点的指针地址)

链表结构特点: 空间上不一定是连续的.物理上可能不连续,但是逻辑上是连续.

但是链表结构相对于数组结构,在内存方面肯定是更加占用更多的内存空间的.

![](imgs/link01.png) 



单向循环链表

![](imgs/link02.png) 



***jdk8.x中LinkedList的底层的结构***

***每个节点中包含:***

* ***element - 集合中真正保存的数据***
* ***pre - 上一个节点的指针地址,头结点,pre指向的是null***
* ***next - 下一个节点的指针地址,尾节点的next指向的也是null***

![](imgs/link03.png) 



双向循环链表[jdk6.x]

* 头节点的pre指向的是最后一个节点
* 最后一个节点的next指向的是头节点.

![](imgs/link04.png) 



## 底层剖析 - add方法

~~~java
 private static class Node<E> {//维护的是一个静态内部类Node - 链表结构的节点对象.
        E item;//真实的保存到集合中的数据.
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
----
public boolean add(E e) {
  linkLast(e);
  return true;
}

transient Node<E> last;//链表的节点 - 最后一个节点.默认值是null

void linkLast(E e) {
  //第二次进来 l = last = new Node<>(null, e, null);

  final Node<E> l = last;//l = last == null
  
  //第一次进来的时候newNode = new Node<>(null, e, null);//双向链表
  
  //第二次进来 new Node = new new Node<>(l, e, null);
  //  //第二次进来 - 带参构造...
 // Node(Node<E> prev, E element, Node<E> next) {
   //         this.item = element;
     //       this.next = next;
      //      this.prev = prev;
       // }
  
  //新的节点的prev指向的是last节点.
  final Node<E> newNode = new Node<>(l, e, null);
  
  //第二次进来,当前的新的节点作为最后一个节点...
  last = newNode;//由于是第一次进来,第一个节点同时也是尾节点
  
  if (l == null)//第一次进来是成立的.
    first = newNode;//第一个节点就是头节点.
  else
    //把之前的最后一个节点的next也要指向新的节点.
    l.next = newNode;
  size++;//统计链表结构的元素的个数.统计节点的个数.
  modCount++;//判断是否出现并发修改的异常.
}
~~~



## 底层剖析 - 查询效率

~~~java
public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }
 Node<E> node(int index) {
    
   //假设size = 10
    //假设index = 5
   //size - 对应的节点的个数 - 对应的集合的大小.
   
   //采用的二分搜索法.
    if (index < (size >> 1)) {//1 0 1 0 >> 1 = 1 0 1 = 5
      Node<E> x = first;//拿到头结点.
      for (int i = 0; i < index; i++)
        x = x.next;//x = x.next = 头结点.next
      //x = index - 1;
      return x; // 目标
    } else {
      Node<E> x = last;//拿到最后一个节点.
      for (int i = size - 1; i > index; i--)
        x = x.prev;
      return x; // 目标
    }
  }
~~~

## 底层剖析 - remove方法

~~~java
public E remove(int index) {
  checkElementIndex(index);
  return unlink(node(index));
  //return unlink(删除的目标节点Node对象)
}

 /**
     * Unlinks non-null node x.
     */
E unlink(Node<E> x) {//x是删除目标节点Node
  // assert x != null;
  final E element = x.item;//获取目标节点对象中的item - 真实的存储的数据.
  
  final Node<E> next = x.next;//获取目标节点的下一个节点
  final Node<E> prev = x.prev;//获取目标节点的上一个节点

  if (prev == null) {//说明是头结点
    first = next;
  } else {
    prev.next = next;//把目标节点的上一个节点的next指向原先这个目标节点的next对应的节点.
    x.prev = null;//目的是这样的,尽快的将引用x.pre指向null,目的是为了尽快让GC回收.
  }

  if (next == null) {//说明是尾节点
    last = prev;
  } else {
    next.prev = prev;//目标节点的下一个节点的pre指向原先节点的上一个节点
    x.next = null;
  }

  x.item = null;//目的也是吸引GC注意,及时进行GC回收...
  size--;
  modCount++;
  return element;
}

~~~





















