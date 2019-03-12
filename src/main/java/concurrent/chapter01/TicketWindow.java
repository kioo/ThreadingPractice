package concurrent.chapter01;

/**
 * 模拟叫号系统
 */
public class TicketWindow extends Thread {
    private final String name;
    private static final int MAX = 50;
    private static int index = 1;

    private TicketWindow(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while(index <= MAX){
            System.out.println("柜台："+ name +"当前的号码是："+(index++));
        }
    }

    public static void main(String[] args) {
        TicketWindow ti1 = new TicketWindow("一号出号机");
        ti1.start();

        TicketWindow ti2 = new TicketWindow("二号出号机");
        ti2.start();

        TicketWindow ti3 = new TicketWindow("三号出号机");
        ti3.start();

        TicketWindow ti4 = new TicketWindow("四号出号机");
        ti4.start();
    }
}
