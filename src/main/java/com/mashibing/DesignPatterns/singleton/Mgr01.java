package com.mashibing.DesignPatterns.singleton;

/**
 * 饿汉式
 * 类加载到内存后,就实例化一个单例,JVM保证线程安全
 * 简单实用,推荐使用
 * 唯一缺点:不管用到与否,类装载时就完成实例化
 * @author william
 * @create 2021-11-06 12:38
 **/
public class Mgr01 {
    private  static  final Mgr01 INSTANCE =new Mgr01();

    private Mgr01() {
    }

    public static Mgr01 getInstance(){
        return INSTANCE;
    }
    public void m(){
        System.out.println("mmm");
    }


}
