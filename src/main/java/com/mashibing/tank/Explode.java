package com.mashibing.tank;

import java.awt.*;

/**
 * @author william
 * @create 2021-10-31 23:21
 **/
public class Explode {

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;

    private boolean living = true;
    TankFrame tankFrame = null;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tankFrame = tf;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) tankFrame.explodes.remove(this);
    }

    public Explode() {
    }


}