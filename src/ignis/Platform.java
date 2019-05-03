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
    public Platform(int x, int y, int width, int height, String type, BufferedImage b ) {
        super(x, y);
        this.initialX = x;
        this.initialY = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.movingLeft = true;
        this.blockImage = b;
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
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(blockImage, getX(), getY(), getWidth(), getHeight(), null);            
    }
    
}
