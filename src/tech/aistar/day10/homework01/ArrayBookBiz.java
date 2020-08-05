package tech.aistar.day10.homework01;


import java.util.Arrays;

/**
 * 本类功能:数组图书管理业务实现类
 *
 * @author cxylk
 * @date 2020/7/31 20:07
 */
public class ArrayBookBiz implements IBookBiz {
    private static final int CAPACITY = 5;

    //有效图书数量
    private int count;

    private Book[] books = new Book[CAPACITY];


    @Override
    public void add(Book b) {
        //注意扩容
        if(count==books.length){
            System.out.println("====两倍扩容====");
            books=Arrays.copyOf(books,books.length*2);
        }
        books[count++]=b;
    }

    @Override
    public void deleteByName(String name) {
        //先统计name图书的数量
        int pos=0;

        for (int i = 0; i < count; i++) {
            if(books[i].getBookName().equals(name)){
                pos++;
            }
        }

        //判断图书是否存在
        if(pos==0){
            System.out.println("sorry,该图书不存在!");
            return;
        }

        //确定新的数组的长度
        Book[] temp=new Book[count-pos];

        //定义一个下标计数器
        int index=0;

        for (int i = 0; i < count; i++) {
            if(!books[i].getBookName().equals(name))
                temp[index++]=books[i];
        }
        books=temp;
        //修改一下count的值，也发生了变化
        count=count-pos;
    }

    @Override
    public void deleteById(int id) {
        //1.确定id对应的图书在books数组的下标
        int pos=1;
        for (int i = 0; i < count; i++) {
            if(books[i].getId()==id){
                pos=i;
                break;//id是唯一的
            }
        }
        if(pos==-1){
            System.out.println("sorry,图书不存在");
            return;
        }
        //从左到右...
        for (int i = pos; i < count-1; i++) {
            books[i]=books[i+1];
        }

        books=Arrays.copyOf(books,count-1);
        count=count-1;
    }

    @Override
    public void outputAllBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }
}

