package java1031;

/**
 * @Author: ruan
 * Date: 2021/10/31 21:40
 * @Description: 设计模式-单例-懒汉式
 */
public class LazySingleton {
    /**
     * 保证线程同步instance
     */
    private static volatile LazySingleton instance = null;

    /**
     * 私有化构造方法
     */
    private LazySingleton(){}

    /**
     * 同步方法获取实例
     * @return
     */
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
