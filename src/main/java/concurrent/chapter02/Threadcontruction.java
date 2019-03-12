package concurrent.chapter02;

/**
 * main线程所在的Threadgroup称为 main
 * 构造一个线程的时候如果没有显示的声明ThreadGroup，那么就会和父线程同属于一个ThreadGroup
 */
public class Threadcontruction {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(group,"t2");
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("Main thread belog group: "+mainThreadGroup.getName());

        System.out.println("t1 and mina belong the same group:"+(mainThreadGroup == t1.getThreadGroup()));
        System.out.println("t2 and mina belong the same group:"+(mainThreadGroup == t2.getThreadGroup()));
        System.out.println("t2 thread group belong main TestGroup:"+(group == t2.getThreadGroup()));

    }
}
