package concurrent.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FightQueryExample {
    // ① 合作的各大航空公司
    private static List<String> fightCompany = Arrays.asList("CSA","CEA","HNA");

    public static void main(String[] args) {
        List<String> results = search("SH","BJ");
        System.out.println("==========================result========================");
        results.forEach(System.out::println);
    }
    private static List<String> search(String original,String dest){
        final List<String> result = new ArrayList<>();
        // ② 创建查询航班信息的线程列表
        List<FightQueryTask> tasks = fightCompany.stream().map(f -> createSearchTask(f,original,dest))
                .collect(toList());
        // ③ 分别启动这几个线程
        tasks.forEach(Thread::start);
        // ④ 分别调用每一个线程的join方法，阻塞当前线程
        tasks.forEach(t ->
                {
                    try{
                        t.join();
                    }catch (InterruptedException e){}
                }
        );
        tasks.stream().map(FightQueryTask::get).forEach(result::addAll);
        return result;
    }
    private static FightQueryTask createSearchTask(String fight,String original,String dest){
        return new FightQueryTask(fight,original,dest);
    }
}
