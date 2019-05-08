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
     * @param x x position of the platform
     * @param y y position of the platform
     * @param width width of the platform
     * @param height height of the platform
     * @param type type of the platform
     * @param b image of the platform
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
     * get the platform with
     * @return platform width
     */
    public int getWidth() {
        return width;
    }

    /**
     * set the platform width
     * @param width of the platform
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * get the platform Height
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     *  set platform height
     * @param height of the platform
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     *  get the platfrom bounds
     * @return a Rectangle object
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    /**
     * get the platfrom left bounds
     * @return a Rectangle object
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
     * get the platform upper bounds
     * @return a Rectangle object
     */
    public Rectangle getPerimetroUp() {
        return new Rectangle(getX(), getY()-20, getWidth(), getHeight()+10);
    }

    /**
     * get the platform bottom bounds
     * @return a Rectangle object
     */
    public Rectangle getPerimetroDown() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight()+10);
    }

    /**
     * 
     * @return boolean if the player intesects with the platform
     */
    public boolean isIntersected() {
        return intersected;
    }

    /**
     *  set boolean to interected variable
     * @param intersected
     */
    public void setIntersected(boolean intersected) {
        this.intersected = intersected;
    }

    /**
     *
     * @return type of the platform
     */
    public String getType() {
        return type;
    }

    /**
     * set the type of the `platform
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * update the platfrom
     */
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
    /**
     * render the platform on the display
     * @param g game object
     */
    @Override
    public void render(Graphics g) {
        if (!intersected) {
            g.drawImage(blockImage, getX(), getY(), getWidth(), getHeight(), null);

        } else {
            g.drawImage(Assets.brownSquare, getX(), getY(), getWidth(), getHeight(), null);
        }
    }

}
