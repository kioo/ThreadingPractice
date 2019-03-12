package concurrent.chapter01;

/**
 * 实现Runnable接口的叫号系统
 * 但是存在线程安全问题
 */
public class TicketWindowRunnable implements Runnable {

    private int index = 1;
    private final static int MAX = 5000;

    @Override
    public void run() {
        while(index <= MAX){
            System.out.println(Thread.currentThread()+"的号码是："+(index++));
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();
        Thread windowThread1 = new Thread(task,"一号窗口");
        Thread windowThread2 = new Thread(task,"二号窗口");
        Thread windowThread3 = new Thread(task,"三号窗口");
        Thread windowThread4 = new Thread(task,"四号窗口");

        windowThread3.start();
        windowThread1.start();
        windowThread2.start();
        windowThread4.start();
    }
}
