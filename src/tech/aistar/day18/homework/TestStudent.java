package tech.aistar.day18.homework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import tech.aistar.util.DateUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/19 21:27
 */
public class TestStudent {
    public static void main(String[] args) {
        for (Student student : find()) {
            System.out.println(student);
        }
    }

    public static List<Student> find() {
        List<Student> students = new ArrayList<>();
        try (InputStream in = new FileInputStream("src/study/cx/day18/homework/student.xml")) {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(in);
            Element root = doc.getRootElement();
            List<Element> list = root.elements("student");
            if (null != list && list.size() > 0) {
                for (Element e : list) {
                    Student s = new Student();
                    s.setId(Integer.valueOf(e.attributeValue("id")));
                    s.setName(e.elementTextTrim("name"));
                    s.setNo(Integer.parseInt(e.elementTextTrim("no")));
                    s.setBirthday(DateUtil.parse(e.elementTextTrim("birthday"), "yyyy-MM-dd"));
                    Element address = e.element("address");
                    if (null != address) {
                        Address ad = new Address();
                        ad.setCity(address.elementTextTrim("city"));
                        ad.setProvince(address.elementTextTrim("province"));
                        s.setAddress(ad);
                    }
                    students.add(s);
                }
            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
        return students;
    }
}
