package tech.aistar.day18.homework;

import java.util.Date;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/19 21:21
 */
public class Student {
    private Integer id;
    private String name;
    private Integer no;

    private Date birthday;
    private Address address;

    public Student() {
//        this.no = no;
    }

    public Student(Integer id,Integer no, String name, Date birthday) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", no=").append(no);
        sb.append(", birthday=").append(birthday);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
