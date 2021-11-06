package com.mashibing.tank;

/**
 * @author william
 * @create 2021-10-30 21:03
 **/
public class T {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount")) ;
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tankFrame.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tankFrame));
        }
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }
    }
}
