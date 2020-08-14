package tech.aistar.day16.numletter;

/**
 * 本类功能:
 *
 * 本类用来演示: 练习 - a1b2c3...
 * 俩个线程,一个负责输出小写,一个负责输出数字,但是要求是依次循环打印.
 *
 * @author cxylk
 * @date 2020/8/14 14:44
 */
public class NumLetter {
    private boolean flag;//初值为false
    public synchronized void printLetter(){
        for (char i = 'a'; i <= 'z'; i++) {
            if(flag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.print(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag=true;
            notify();
        }
    }

    public synchronized void printNumber(){
        for (int i = 1; i <=26 ; i++) {
            if(flag==false){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.print(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag=false;
            notify();
        }
    }

    public static void main(String[] args) {
        NumLetter n=new NumLetter();

//        Thread t1=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                n.printLetter();
//            }
//        });

        Thread t1=new Thread(()->{
            n.printLetter();
        });

//        Thread t2=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                n.printNumber();
//            }
//        });

        Thread t2=new Thread(()->{
            n.printNumber();
        });

        t1.start();
        t2.start();
    }
}
