package com.mashibing.tank;

import lombok.Data;

import java.awt.*;

/**
 * @author william
 * @create 2021-10-31 23:21
 **/
@Data
public class Bullet {
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Group group = Group.BAD;
    private int x, y;
    private Dir dir;
    private boolean living = true;
    TankFrame tankFrame = null;
    Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir,Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.group = group;
        this.dir = dir;
        this.tankFrame = tf;
        rect.x =x;
        rect.y=y;
        rect.width=WIDTH;
        rect.height=HEIGHT;
        tf.bulletList.add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.bulletList.remove(this);
            return;
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        rect.x =x;
        rect.y=y;
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;

    }

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        Rectangle bullectRect = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle tankRect = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (bullectRect.intersects(tankRect)) {
            //this.die();
            tank.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tankFrame.explodes.add(new Explode(eX,eY,tankFrame));
        }
    }

    private void die() {
        this.living = false;
    }

}
