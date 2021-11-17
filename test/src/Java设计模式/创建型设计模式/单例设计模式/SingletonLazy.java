package Java设计模式.创建型设计模式.单例设计模式;

import java1031.LazySingleton;

/**
 * @Author: ruan
 * Date: 2021/11/17 14:29
 * @Description: 单例，懒汉式
 */
public class SingletonLazy {
    private static volatile SingletonLazy instance;
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
     * 第二种方法
     * 通过synchronized加锁保证单例
     * 采用synchronized对方法加锁有很大的性能开销
     * 解决方法：降低锁粒度
     * @return
     */
    /*public synchronized static SingletonLazy getInstance(){
        if (instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }*/

    /**
     * 第三种方法
     * DCL双重检查锁定（Double-Checked-Locking），多线程情况下保证高性能
     * 是否安全？
     * instance = new SingletonLazy()并不是原子性操作？
     * 1、分配空间给对象
     * 2、在空间内创建对象
     * 3、对象赋值给引用
     * 所以要加上volatile关键字，防止指令重排序
     * @return
     */
    public static SingletonLazy getInstance(){
        //第一重检查
        if (instance == null){
            //线程锁定
            synchronized (LazySingleton.class){
                //第二重检查
                if (instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

}
