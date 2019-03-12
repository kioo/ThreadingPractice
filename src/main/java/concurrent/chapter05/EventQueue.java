package concurrent.chapter05;

import concurrent.chapter03.CurrentThread;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;

/**
 * 队列测试类
 * 下面两个方法offer往队列放入数据，take用来取出数据
 */
public class EventQueue {
    private final int max;
    static class Event{}

    private final LinkedList<Event> eventQueue = new LinkedList<>();
    private final static int DEFAULT_MAX_EVENT = 10;
    public EventQueue(){
        this(DEFAULT_MAX_EVENT);
    }
    private EventQueue(int max){
        this.max = max;
    }

    /**
     * 提交一个Event至队尾
     * @param event
     */
    public void offer(Event event){
       synchronized (eventQueue){
           if (eventQueue.size() >= max){
               try{
                   console("the queue is full.");
                   eventQueue.wait();
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
           console("the new event is submitted");
           eventQueue.addLast(event);
           eventQueue.notify();
       }
    }

    /**
     * 从队头获取数据
     * @return
     */
    public Event take(){
        synchronized (eventQueue){
            if (eventQueue.isEmpty()){
                try{
                    console("the queue is empty.");
                    eventQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            console(" the event "+ event + "is handled.");
            return event;
        }
    }

    public void console(String message){
        System.out.printf("%s:%s\n", currentThread().getName(),message);
    }
}
