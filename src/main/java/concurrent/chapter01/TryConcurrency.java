package concurrent.chapter01;


import java.util.concurrent.TimeUnit;

public class TryConcurrency {

    /*public static void main(String[] args) {
        browseNews();
        enjoyMusic();
    }*/
    // 上面的方法不会使调用的两个方法交替执行，只有使用Thread进行包裹才能实现更替
   public static void main(String[] args) {
        // 通过匿名类创建线程，并重新run方法
        new Thread(){ // ①
            @Override
            public void run() {
                enjoyMusic();
            }
        }.start(); // ②
        browseNews();
    }
   // 使用lambda 表达式改造上面方法
    /*public static void main(String[] args) {
        new Thread(TryConcurrency::enjoyMusic).start();
        browseNews();
    }*/
    /**
     * browse the latest news
     */
    private static void browseNews(){
        for(; ; ){
            System.out.println("uh-huh, the good news .");
            sleep(1);
        }
    }

    /**
     * Listening and enjoy the music
     */
    private static void enjoyMusic(){
        for(; ; ){
            System.out.println("Uh-huh,the nice music.");
            sleep(1);
        }
    }
    /**
     * simulate the wait and ignore exception
     */
    private static void sleep(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
