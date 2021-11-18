package Java设计模式.创建型设计模式.单例设计模式;

/**
 * @Author: ruan
 * Date: 2021/11/17 15:12
 * @Description: 单例设计模式-饿汉式
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();
    private SingletonHungry (){};
    public static SingletonHungry getInstance(){
        return instance;
    }
}
