package com.mashibing.tank;


import java.io.IOException;
import java.util.Properties;

/**
 * @author william
 * @create 2021-11-06 0:02
 **/
public class PropertyMgr {
    static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (properties == null) return null;
        return properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }

}
