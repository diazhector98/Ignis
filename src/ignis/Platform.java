/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.Assets;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Date;

/**
 *
 * @author hectordiazaceves
 */
public class Platform extends Item{
    
    private int width;
    private int height;
    private String type;
    private int initialX;
    private int initialY;
    private boolean movingLeft;
    private BufferedImage blockImage;
    private boolean intersected;

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param type
     * @param b
     */
    public Platform(int x, int y, int width, int height, String type, BufferedImage b ) {
        super(x, y);
        this.initialX = x;
        this.initialY = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.movingLeft = true;
        this.blockImage = b;
        this.intersected = false;
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
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    /**
     *
     * @return
     */
    public Rectangle getPerimetroLeft() {
        return new Rectangle(getX()-10 , getY(), 100, 100);
    }
    
    /**
     *
     * @return
     */
    public Rectangle getPerimetroRight() {
        return new Rectangle(getX()+10, getY(), 100, 100);
    }

    /**
     *
     * @return
     */
    public Rectangle getPerimetroUp() {
        return new Rectangle(getX(), getY()-20, getWidth(), getHeight()+10);
    }

    /**
     *
     * @return
     */
    public Rectangle getPerimetroDown() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight()+10);
    }

    /**
     *
     * @return
     */
    public boolean isIntersected() {
        return intersected;
    }

    /**
     *
     * @param intersected
     */
    public void setIntersected(boolean intersected) {
        this.intersected = intersected;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public void tick() {
        if(type == "ACTIVE"){
            if(movingLeft){
                setX(getX() - 1);
                if(getX() < initialX - 100){
                    movingLeft = false;
                }
            } else {
                setX(getX() + 1);
                if(getX() > initialX + getWidth() + 100){
                    movingLeft = true;
                }
            }
        } else if( type == "ATOM"){
            
        }
    }

    @Override
    public void render(Graphics g) {
        if (!intersected) {
            g.drawImage(blockImage, getX(), getY(), getWidth(), getHeight(), null);

        } else {
            g.drawImage(Assets.brownSquare, getX(), getY(), getWidth(), getHeight(), null);
        }
    }

}
