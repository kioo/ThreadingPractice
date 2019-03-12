package concurrent.chapter01;

import java.sql.ResultSet;

/**
 * 策略模式在thread中的体现
 * RowHandler接口值负责对数据库查询处理的数据进行操作，，至于返回什么样的数据结构，需要自己去实现。类似runnable接口
 * @param <T>
 */
public interface RowHandler<T> {
    T handle(ResultSet rs);
}
