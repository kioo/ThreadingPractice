package concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * interrupt 方法，中断阻塞状态的线程
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->
        {
           try{
               TimeUnit.MINUTES.sleep(1);
           }catch (InterruptedException e){
               System.out.println("oh,i am be interrupted");
           }
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
