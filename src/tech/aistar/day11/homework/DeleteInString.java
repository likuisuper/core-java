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
        String pattern="ow";
        String str=deleteString(pattern,test);
        System.out.println(str);
    }

    public static String deleteString(String pattern,String text){
        int index=0;
        while((index=text.indexOf(pattern))!=-1){
            text=text.replace(pattern,"");
        }
        return text;
    }
}
