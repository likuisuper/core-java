package tech.aistar.day16.numletter;

/**
 * 本类功能:a12b34c56d78
 *
 * @author cxylk
 * @date 2020/8/14 20:26
 */
public class NumLetter02 {
    private boolean flag;

    public synchronized void printLetter(){
        for (char i = 'a'; i <='z' ; i++) {
            if(flag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //刚进来,flag为false,执行下面
            System.out.print(i);

            try {
                Thread.sleep(1000);//睡1s,cpu去执行第二个线程,然后接着回来执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag=true;

            notify();//唤醒下面阻塞的线程
        }
    }

    public synchronized void printNumber(){
        for (int i = 1; i <=26 ; i+=2) {
            if(flag==false){//第一次进来走这
                try {
                    wait();//睡眠
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.print(i+""+(i+1));//两个数字连着打印

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
        NumLetter02 n=new NumLetter02();

        Thread t1=new Thread(()->{
            n.printLetter();
        });

        Thread t2=new Thread(()->{
            n.printNumber();
        });

        t1.start();
        t2.start();
    }
}
