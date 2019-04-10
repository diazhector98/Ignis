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

    public Platform(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
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
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.darkGraySquare, getX(), getY(), getWidth(), getHeight(), null);
    }
    
}
