package com.mashibing.tank;

/**
 * @author william
 * @create 2021-11-07 21:58
 **/
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Dir[] dirs = Dir.values();
        for (Dir dir :dirs){
            new Bullet(bX, bY, dir, tank.getGroup(), tank.getTankFrame());
        }
        if (tank.getGroup() == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
