package tech.aistar.day11.homework;

/**
 * 本类功能:根据指定的字符串到原来的字符串中进行删除操作
 *
 *
 * @author cxylk
 * @date 2020/8/3 20:14
 */
public class DeleteInString {
    public static void main(String[] args) {
        String test="helloworld";
        String pattern="he";
        String str=deleteString(pattern,test);
        System.out.println(str);
    }

//    public static String deleteString(String pattern,String text){
//        int index=0;
//        while((index=text.indexOf(pattern))!=-1){
//            text=text.replace(pattern,"");
//        }
//        return text;
//    }

    public static String deleteString(String delStr,String oldStr){
        if (null==delStr||delStr.length()==0)
            return null;
        if(!oldStr.contains(delStr))
            return oldStr;
        int start=oldStr.indexOf(delStr);
        int end=start+delStr.length();
        StringBuilder sb=new StringBuilder(oldStr);
        sb.delete(start,end);
        return deleteString(delStr,sb.toString());
    }
}
