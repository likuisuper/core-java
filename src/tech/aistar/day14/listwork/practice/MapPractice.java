package tech.aistar.day14.listwork.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 本类功能:
 *
 * 7、给定一一个包含员工key (ID)， value (dob出生日期)的输入作为HashMap
 * 写一个程序找到适合退休的员工，并按照工号正序输出，退休的条件是年龄大于
 * 等于60岁。
 * 假设当前的日期是01/01/2014
 * 输入日期的格式dd/MM/yyyy
 * 输入包含2n+1个元素，第一个表示输入的员工人数，接下来n对个数，分别表
 * 示员工的id与出生日期
 * Sample Input:
 * 4
 * C1010
 * 02/11/1987
 * C2020
 * 15/02/1980
 * C3030
 * 14/12/1952
 * T4040
 * 20/02/1950
 *
 * Sample Qutput
 * [C3030, T4040]
 *
 * @author cxylk
 * @date 2020/8/7 18:11
 */
public class MapPractice {
    public static void main(String[] args) throws ParseException {
        test();
    }

    public static void test() throws ParseException {
        Scanner scanner=new Scanner(System.in);
        String value=scanner.nextLine();
        int pairs=Integer.parseInt(value);

        Map<String, Date> map=new HashMap<>();

        for (int i = 0; i < pairs; i++) {
            String no=scanner.nextLine();
            String date=scanner.nextLine();
            map.put(no,stringToDate(date));
        }

        //当前日期
        Date currDate=stringToDate("01/01/2014");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currDate);//将日期转换为日历
        //设置当前日期的年份减去60,这个就是后面比较日期大小的基数
        calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)-60);

        //遍历map这个员工的信息 所有Key(工号)的集合
        Set<String> empSet=map.keySet();
        //获取set集合遍历的迭代器
        Iterator<String> empIterator=empSet.iterator();

        List<String> setEmp=new ArrayList<>();

        //通过迭代器进行遍历
        while(empIterator.hasNext()){
            //获取工号信息
            String empNo=empIterator.next();
            //根据工号信息获取其出生日期
            Date birthDate=map.get(empNo);
            //转换为可以与基数日期比较的相同类型对象
            Calendar calendar1=Calendar.getInstance();
            calendar1.setTime(birthDate);

            if(calendar.compareTo(calendar1)>=0){
                setEmp.add(empNo);
            }
        }

        setEmp.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(String s:setEmp){
            System.out.println(s);
        }
    }

    public static Date stringToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(dateStr);
    }
}
