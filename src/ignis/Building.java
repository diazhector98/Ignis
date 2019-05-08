/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class Building {
    
    private BufferedImage image;
    private int width;
    private int height;
    private int x;
    private int y;

    /**
     *
     */
    protected Game game;

    /**
     *
     */
    protected Player player;
    
    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     * @param g
     */
    public Building(int x, int y, int width, int height, BufferedImage image, Game g){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.image = image;
        this.game = g;
        this.player = g.getPlayer();
    }

    /**
     *
     * @return
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     *
     * @param g
     */
    public void render(Graphics g){
        g.drawImage(this.image , getX(), getY(), getWidth(), getHeight(), null);
    }
    
    /**
     *
     * @return
     */
    public Rectangle getPerimeter(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    /**
     *
     * @return
     */
    public Rectangle getDoorPerimeter(){
        return new Rectangle(getX() + getWidth() / 2, getY() + getHeight(), 100, 100);
    }
    
}
