package tech.aistar.day13.exercise;

import java.util.Arrays;

/**
 * 本类功能:手写list的add,get方法
 *
 * @author cxylk
 * @date 2020/8/6 13:57
 */
public class SuccessList<E> {
    public Object[] datas = new Object[10];
    int size;

    /**
     * 添加数据...
     * @param e
     */
    public void add(E e){
        if(size==datas.length){
            datas= Arrays.copyOf(datas,datas.length*2);
        }
        datas[size++]=e;
    }

    /**
     * 根据下标获取元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index>=size)
            return null;
        return (E) datas[index];
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(i!=size-1?datas[i]+",":datas[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SuccessList<String> s=new SuccessList<>();
        s.add("ok");
        s.add("good");
        s.add("good");
        s.add("good");
        s.add("good");
        s.add("good");
        s.add("good");
        s.add("good");
        s.add("good");
        s.add("good");
        s.add("good");
        s.add("good");
        System.out.println(s);

        System.out.println(s.get(0));
    }
}

