/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.Graphics;
import java.awt.Rectangle;

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
    public Platform(int x, int y, int width, int height, String type ) {
        super(x, y);
        this.initialX = x;
        this.initialY = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.movingLeft = true;
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
        g.drawImage(Assets.darkGraySquare, getX(), getY(), getWidth(), getHeight(), null);            
    }
    
}
