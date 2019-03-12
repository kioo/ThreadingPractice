package concurrent.chapter01;

/**
 * 线程的模板设计模式的示例
 */
public class TemplateMethod {
    public final void print(String message){
        System.out.println("#############");
        wrapPrint(message);
        System.out.println("#############");

    }

    protected void wrapPrint(String message){

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*"+message+"*");
            }
        };
        t1.print("hello thead");
        TemplateMethod t2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+"+message+"+");
            }
        };
        t2.print("hello Thread");
    }
}
