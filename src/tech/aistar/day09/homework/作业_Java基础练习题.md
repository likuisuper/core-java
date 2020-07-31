####  1. 请阅读下面的程序 （   C ）

```java
public static void main(String[] args) { 
   int x = 0; 
   int y = 0; 
   boolean b = x == 0 || y++ > 0; //b = true 短路或，后面不执行
   System.out.println(“b = ” + b + “, y = ” + y); 

  } 
   程序的运行结果是（ ）
   A. b = false, y = 0
   B. b = false, y = 1
   C. b = true, y = 0 
   D. b = true, y = 1  
```

####  2. 请阅读下面的程序：

```java
 
public static void main(String[] args) {
	int i = 127;
	byte b = i;//i是一个可在int类型范围变化的变量
	System.out.println(b);
}

该段程序的运行结果是(  A )
A. 编译报错。
B. 编译通过，运行输出127。
C. 编译通过，运行时报错。
D. 其他选项均不正确。
```

#### 3. 读程序，选出输出结果(A)

```java

public static void main(String[] args) {
    Nowcoder nowcoder = new Nowcoder();
    int i = 0;
    nowcoder.inc(i);//基本类型 - 值传递 - "文件的拷贝"
    i = i++;  
    System.out.println(i);
}
void inc(int i) {
    i++;
}
A. 0   
B. 1
C. 2
D. 3
```



#### 5. 以下程序的执行结果是：(A)

```java

static boolean foo(char c){
 	System.out.print(c);
 	return true;
 }
 public static void main(String[] args) {
     int i =0;
     for(foo('A');foo('B')&&(i<2);foo('C')) {
 				i++;
 				foo('D');
 		}
 }
A. ABDCBDCB 
B. ABCDABCD
C. 编译时出错
D. 运行时抛出异常
```

#### 6. 关于下面的一段代码，以下哪些说法是正确的：

```java
public static void main(String[] args) {
    String a = new String("myString");
    String b = "myString";
    String c = "my" + "String";
    String d = c;
    System.out.print(a == b);//false
    System.out.print(a == c);//false
    System.out.print(b == c);//true
    System.out.print(b == d);//true
}

A. System.out.print(a == b)
B. System.out.print(a == c)
C. System.out.print(b == c)
D. System.out.print(b == d)
```

#### 7. 下面java程序的运行结果是(C)

```java
class A {
    static {
        System.out.print("A");
    }
    public A() {
        System.out.print("a");
    }
}
class B extends A {
    static {
        System.out.print("B");
    }
    public B() {
        System.out.print("b");
    }
}
public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
}
A. ABabABab
B. AaBbAaBb
C. ABabab  
D. AaBbBb
```

#### 8.下面关于java static的描述错误的有?

```java
A. static表示“全局”或者“静态”的意思，用来修饰成员变量和成员方法,但是不能来修饰代码块 false
B. static int arr[] = new int[5];arr里面的数字全部都会初始化为0 true
C. 对于静态变量在内存中只有一个拷贝，JVM只为静态分配一次内存，在加载类的过程中完成静态变量的内存分配,可以通过对象来访问 false
D. static对象可以在它的任何对象创建之前访问，无需引用任何对象 true
```

#### 9. Test.main()函数执行后的输出是（ B ）

```java

class Test {
    public static void mBain(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}

A. 6 7 7
B. 22 34 17
C. 22 74 74
D. 11 17 34
```

#### 10.下面java程序的运行结果是(D)

```java
 
class A {
    static {
        System.out.print("A");
    }
    public A() {
        System.out.print("a");
    }
    void say() {
        System.out.print("1");
    }
}
class B extends A {
    static {
        System.out.print("B");
    }
    public B() {
        System.out.print("b");
    }
    void say() {
        System.out.print("2");
    }
}
public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab.say();
        ab = new B();
        ab.say();
    }
}
A. ABab2ABab2
B. AaBb1AaBb2
C. ABab1ab2
D. ABab2ab2  
```

#### 11. 关于static说法不正确的是（D）

```
A. 可以直接用类名来访问类中静态方法(public权限)
B. 静态块仅在类加载时执行一次
C. static方法中不能有用this调用的方法
D. 不可以用对象名来访问类中的静态方法(public权限) 
```

#### 12.关于下列程序段的输出结果，说法正确的是：（D） 

```java
 public class MyClass{

	static int i;
  public static void main(String argv[]){
  System.out.println(i);
  }
}

A. 有错误，变量i没有初始化。
B. null
C. 1
D. 0
```

#### 13.下列代码的执行结果是：（B） 

```java
public class Test3{
 public static void main(String args[]){
    System.out.println(100%3);
    System.out.println(100%3.0);
 }
}

A. 1和1
B. 1和1.0
C. 1.0和1
D. 1.0和1.0
```



#### 14.假设 A 类有如下定义，设 a 是 A 类的一个实例，下列语句调用哪个是错误的？（C）

```java
public class A{

    public int i;
    static String s;
    void method1(){}	

	static void method2(){}

}

A. System.out.println(a.i);
B. a.method1();
C. A.method1();
D. A.method2();
```

#### 15.如下代码的 结果是什么（ B）

```java

class Base {
    Base() {
    	System.out.print("Base");
    }
}
public class Alpha extends Base {
    public static void main( String[] args ) {
        new Alpha();
        //调用父类无参的构造方法
        new Base();
    }
}

A. Base
B. BaseBase
C. 编译失败
D. 代码运行但没有输出
E. 运行时抛出异常
```

#### 16.如下代码的输出结果是什么 ( D)

```java
 
public class Test {
    public int aMethod(){
        static int i = 0;//error
        i++;
        return i;
    }
public static void main(String args[]){
    Test test = new Test();
    test.aMethod();
    int j = test.aMethod();
    System.out.println(j);
    }
}

A. 0
B. 1
C. 2
D. 编译失败
```

#### 

```java

```

#### 18. 有如下一段代码，请选择其运行结果（C）

```java
 //将其加载进常量池中   MESSAGE
public class StringDemo{
  private static final String MESSAGE="taobao";
  public static void main(String [] args) {
    String a ="tao"+"bao";
    String b="tao";
    String c="bao";
    System.out.println(a==MESSAGE);//true
    System.out.println((b+c)==MESSAGE);//false
  }
}
A. true true
B. false false
C. true false
D. false true
```



#### 19. 运行main函数后, n值是 __3__ , m值是_____3__

```java
 已知如下代码 
 
public static void main( String[]args)\{
    int m = 3;
    int n = 4;
    n = --m & n++;
    n = ++m | n++;
    System.out.println(n++);
    System.out.println(m);
}

```

20. #### 以下代码将打印出 (   )

```java
 public static void main (String[] args) { 
    String classFile = "com.jd.". replaceAll(".", "/") + "MyClass.class";//点号可以匹配"任意字符"C
    System.out.println(classFile);
}
A. com. jd
B. com/jd/MyClass.class
C. ///////MyClass.class
D. com.jd.MyClass
```



#### 简述题

```
如果类Dog 有一个static 变量owner. 请问若有50个Dog对象, 内存中应该一共有多少个owner的拷贝,并说明原因?
 
1
```

