package java1031;

/**
 * @Author: ruan
 * Date: 2021/10/31 21:46
 * @Description: 设计模式-单例-饿汉式
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}
