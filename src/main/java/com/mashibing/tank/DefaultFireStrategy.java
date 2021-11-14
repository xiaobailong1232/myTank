package com.mashibing.tank;

/**
 * @author william
 * @create 2021-11-07 21:43
 **/
public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
       new Bullet(bX, bY, tank.getDir(), tank.getGroup(), tank.getTankFrame());
       if (tank.getGroup() ==Group.GOOD) new Thread(()-> new Audio("audio/tank_fire.wav")).start();
    }
}
