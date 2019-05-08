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
    
    /**
     *
     * @param l
     * @param s
     * @param p
     * @param i
     */
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

    /** getLives
     * Get the lives of the enemy
     * @return <int> lives of the enemy
     */
    public int getLives() {
        return lives;
    }

    /** setLives
     * Set the lives of the enemy
     * @param lives <int> of the enemy
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /** getSpeed
     * Get the speed of the enemy
     * @return <int> speed of the enemy
     */
    public int getSpeed() {
        return speed;
    }

    /** setSpeed
     * Set the speed of the enemy
     * @param speed <int> of the enemy
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /** getPlataform
     * Get the platform
     * @return Platform of the enemy
     */
    public Platform getPlatform() {
        return platform;
    }

    /**setPlataform
     * Set the platform
     * @param platform
     */
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    /** getIndex
     * Get the index of the enemy
     * @return <int> index of the enemy
     */
    public int getIndex() {
        return index;
    }

    /** setIndex
     * Set the index of the enemy
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /** getWidth
     * Get the width of the enemy
     * @return <int> width of the enemy
     */
    public int getWidth() {
        return width;
    }

    /**setWidth
     * Set the width of the enemy
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**getHeight
     * Get the height of the enemy
     * @return <int> height of the enemy
     */
    public int getHeight() {
        return height;
    }

    /**setHeight
     * Set the height of the enemy
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     *
     * @return
     */
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
