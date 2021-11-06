package com.mashibing.DesignPatterns.singleton;

/**
 * @author william
 * @create 2021-11-06 12:41
 **/
public class Main {
    public static void main(String[] args) {
        Mgr01 instance1 = Mgr01.getInstance();
        Mgr01 instance2 = Mgr01.getInstance();
        System.out.println(instance1 ==instance2);
        instance1.m();
    }
}
