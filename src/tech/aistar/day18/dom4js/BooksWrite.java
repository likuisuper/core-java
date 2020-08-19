package tech.aistar.day18.dom4js;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import tech.aistar.day18.entity.Book;
import tech.aistar.day18.entity.BookInfo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本类功能:dom4js来进行写入
 *
 * @author cxylk
 * @date 2020/8/19 20:17
 */
public class BooksWrite {
    public static void main(String[] args) {
        List<Book> books=new ArrayList<>();

        Book b1=new Book(1,"java","james",100.0d);
        BookInfo info1=new BookInfo("驰星出版社",new Date(),100,"好书");
        b1.setBookInfo(info1);

        Book b2=new Book(1,"java","james",100.0d);

        books.add(b1);
        books.add(b2);

        save(books,"src/tech/aistar/day18/bbb.xml");
    }

    public static void save(List<Book> books,String path){
        //1.思路:内存中构建倒置的文档树
        Document doc=DocumentHelper.createDocument();

        //2.添加根元素
        Element root=doc.addElement("books");

        //3.遍历books集合，有多少=个book对象，就应该拥有多少个book标签
        if(null!=books&&books.size()>0){
            //一定在root标签下新建book标签
            for (Book b : books) {
                //创建book元素
                Element be=root.addElement("book");
                //设置book标签属性id以及属性值
                be.addAttribute("id",String.valueOf(b.getId()));

                //book的子标签
                be.addElement("name").setText(b.getName());

                be.addElement("author").setText(b.getAuthor());

                be.addElement("price").setText(String.valueOf(b.getPrice()));

                //book对象有可能设置了bookInfo
                BookInfo info=b.getBookInfo();
                if(null!=info){
                    //创建bookInfo标签
                    Element bie=be.addElement("bookinfo");
                    bie.addElement("publish_house").setText(info.getPublishHouse());
                    bie.addElement("publish_date").setText(String.format("%tF",info.getPublishDate()));
                    bie.addElement("pages").setText(String.valueOf(info.getPages()));
                    bie.addElement("description").setText(info.getDescription());

                }
            }
        }

        //把doc写出去
        XMLWriter out=null;
        try {
            OutputFormat format=new OutputFormat("\t",true);
            out=new XMLWriter(new FileWriter(path),format);
            out.write(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=out){
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
