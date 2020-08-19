package tech.aistar.day18.homework;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/19 21:23
 */
public class StudentWrite {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1,2,"tom",new Date(1999-1-1));
        Address address1 = new Address("江苏","苏州");
        s1.setAddress(address1);

        Student s2 = new Student(1,2,"lk",new Date(1998-12-19));
        students.add(s1);
        students.add(s2);
        save(students,"src/study/cx/day18/homework/bbb.xml");
    }
    public static void save(List<Student> students,String path){
        Document doc =  DocumentHelper.createDocument();
        Element root = doc.addElement("students");
        if(null!=students && students.size()>0){
            for (Student s : students) {
                Element se = root.addElement("student");
                se.addAttribute("id",String.valueOf(s.getId()));
                se.addElement("name").setText(s.getName());
                se.addElement("no").setText(String.valueOf(s.getNo()));
                se.addElement("publish_date").setText(String.format("%tF",s.getBirthday()));
                Address address = s.getAddress();
                if(null!=address){
                    Element ad=se.addElement("Address");
                    ad.addElement("province").setText(address.getProvince());
                    ad.addElement("city").setText(address.getCity());
                }
            }
        }
        XMLWriter out = null;
        try{
            OutputFormat format = new OutputFormat("\t",true);
            out = new XMLWriter(new FileWriter(path),format);
            out.write(doc);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
