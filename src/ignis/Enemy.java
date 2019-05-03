/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.Graphics;
import ignis.Assets.EnemyAssets;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
/**
 *
 * @author hectordiazaceves
 */
public class Enemy extends Item{
    
    private int lives;
    private int speed;
    private Platform platform;
    private int index;
    private boolean turningLeft;
    private boolean turningRight;
    private int width;
    private int height;
    private int initialX;
    private int initialY;
    
    public Enemy(int l, int s, Platform p, int i){
        super(p.getX(), p.getY() - 50);
        
        this.initialX = p.getX();
        this.initialY = p.getY();
        
        this.lives = l;
        this.speed = s;
        this.platform = p;
        this.index = i;
        this.turningLeft = false;
        this.turningRight = true;
        this.width = 70;
        this.height = 70;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    

    @Override
    public void tick() {
        if (turningLeft) {
            setX(getX() - speed);
            if (getX() < initialX - 100) {
                turningLeft = false;
                turningRight = true;
            }
        } else {
            setX(getX() + speed);
            if (getX() > initialX + + 100) {
                turningLeft = true;
                turningRight = false;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        
        if(turningLeft){
            g.drawImage((BufferedImage) EnemyAssets.getEnemyImages(index).getKey(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (turningRight){
            g.drawImage((BufferedImage) EnemyAssets.getEnemyImages(index).getValue(), getX(), getY(), getWidth(), getHeight(), null);
        }
    }
    
    
}
