package tech.aistar.day18.dom4js;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import tech.aistar.day18.entity.Book;
import tech.aistar.day18.entity.BookInfo;
import tech.aistar.util.DateUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 本类功能:解析books
 *
 * @author cxylk
 * @date 2020/8/19 20:46
 */
public class TestBooks {
    public static void main(String[] args) {
        for (Book book : find()) {
            System.out.println(book);
        }
    }

    public static List<Book> find(){
        List<Book> books=new ArrayList<>();

        //1.准备xml的字节输入流
        try(InputStream in=new FileInputStream("src/tech/aistar/day18/dom4js/books.xml")){

            //2.创建SAXReader对象
            SAXReader saxReader=new SAXReader();

            //3.获取doc对象
            Document doc=saxReader.read(in);

            //4.获取根元素
            Element root=doc.getRootElement();

            //5.获取根元素下的所有的book元素
            List<Element> list=root.elements("book");

            //充分体现出对象就是数据在内存中的载体 - 容器
            //准备一个容器来存储所有的book对象

            //6.遍历这个集合
            if(null!=list&&list.size()>0){
                for (Element e : list) {
                    //1.创建一个Book对象
                    Book b=new Book();
                    b.setId(Integer.valueOf(e.attributeValue("id")));

                    //设置name标签中的文本
                    b.setName(e.elementTextTrim("name"));
                    b.setAuthor(e.elementTextTrim("author"));
                    b.setPrice(Double.parseDouble(e.elementTextTrim("price")));

                    //获取book标签下的bookInfo标签对象
                    Element info=e.element("bookInfo");
                    //bookInfo标签是可能不存在的
                    if(null!=info){
                        //创建一个BookInfo对象
                        BookInfo bi=new BookInfo();

                        bi.setPublishHouse(info.elementTextTrim("publish_house"));

                        //String->Date
                        bi.setPublishDate(DateUtil.parse(info.elementTextTrim("publish_date"),"yyyy-MM-dd"));

                        bi.setPages(Integer.parseInt(info.elementTextTrim("pages")));

                        bi.setDescription(info.elementTextTrim("description"));

                        //将bi绑定到b
                        b.setBookInfo(bi);
                    }
                    books.add(b);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return books;
    }
}
