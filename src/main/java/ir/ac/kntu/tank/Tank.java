package ir.ac.kntu.tank;

import ir.ac.kntu.gameObjects.GameObject;
import ir.ac.kntu.move.Collision;

import java.io.Serializable;

public class Tank extends GameObject implements Serializable {


    public int direction;

    private int point;

    private int speed = 2;

    private int bulletPower = 1;

    public Tank(int x, int y) {
        super(x, y);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        point = point;
    }

    public int getBulletPower() {
        return bulletPower;
    }

    public void setBulletPower(int bulletPower) {
        this.bulletPower = bulletPower;
    }

    public int getSpeed() {
        return speed;
    }

    public void update(Tank playerTank) {
        if (playerTank instanceof PlayerTank) {
            if (playerTank.getDirection() == 2 && playerTank.getSpeed() != 0) {
                if (Collision.checkCollision(playerTank)) {
                    playerTank.setY(playerTank.getY() + playerTank.getSpeed());
                }
            } else if (playerTank.getDirection() == 8 && playerTank.getSpeed() != 0) {
                if (Collision.checkCollision(playerTank)) {
                    playerTank.setY(playerTank.getY() - playerTank.getSpeed());
                }
            } else if (this.getDirection() == 4 && playerTank.getSpeed() != 0) {
                if (Collision.checkCollision(playerTank)) {
                    playerTank.setX(playerTank.getX() - playerTank.getSpeed());
                }
            } else if (playerTank.getDirection() == 6 && playerTank.getSpeed() != 0) {
                if (Collision.checkCollision(playerTank)) {
                    playerTank.setX(playerTank.getX() + playerTank.getSpeed());
                }
            }
        }else {
            if (playerTank.getDirection() == 2 && playerTank.getSpeed() != 0) {
                if (Collision.checkCollisionOtherTank(playerTank)) {
                    playerTank.setY(playerTank.getY() + playerTank.getSpeed());
                }
            } else if (playerTank.getDirection() == 8 && playerTank.getSpeed() != 0) {
                if (Collision.checkCollisionOtherTank(playerTank)) {
                    playerTank.setY(playerTank.getY() - playerTank.getSpeed());
                }
            } else if (this.getDirection() == 4 && playerTank.getSpeed() != 0) {
                if (Collision.checkCollisionOtherTank(playerTank)) {
                    playerTank.setX(playerTank.getX() - playerTank.getSpeed());
                }
            } else if (playerTank.getDirection() == 6 && playerTank.getSpeed() != 0) {
                if (Collision.checkCollisionOtherTank(playerTank)) {
                    playerTank.setX(playerTank.getX() + playerTank.getSpeed());
                }
            }
        }
        if (this.getX() < 0) {
            this.setX(0);
        } else if (this.getX() + getObjectWidth() > 650) {
            this.setX(650 - this.getObjectWidth());
        }
        if (this.getY() < 0) {
            this.setY(0);
        } else if (this.getY() + getObjectHeight() > 650) {
            this.setY(650 - this.getObjectHeight());
        }
    }

    public void moveLeft() {
        this.setDirection(4);
    }

    public void moveRight() {
        this.setDirection(6);
    }

    public void moveUp() {
        this.setDirection(8);
    }

    public void moveDown() {
        this.setDirection(2);
    }

    public void stop(PlayerTank playerTank) {
        if (playerTank.getSpeed() == 1) {
            playerTank.setSpeed(0);
        } else if (playerTank.getSpeed() == 0) {
            playerTank.setSpeed(1);
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
