package Java设计模式.创建型设计模式.单例设计模式;

/**
 * @Author: ruan
 * Date: 2021/11/17 14:29
 * @Description: 单例，懒汉式
 */
public class SingletonLazy {
    private static SingletonLazy instance;
    /**
     * 私有化构造方法
     */
    private SingletonLazy(){};

    /**
     * 测试方法
     */
    public void process(){
        System.out.println("方法调用成功");
    }

    /**
     * 第一种方法
     * 对外暴漏一个获取实例的方法(多线程下存在安全问题)
     */
    /*public static SingletonLazy getInstance(){
        if (instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }*/

    /**
     * 通过synchronized加锁保证单例
     * 采用synchronized对方法加锁有很大的性能开销
     * @return
     */
    public synchronized static SingletonLazy getInstance(){
        if (instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }

}
