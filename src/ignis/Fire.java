/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author hectordiazaceves
 */
public class Fire extends Item{
    int width;
    int height;
    public Fire(Platform p, int w, int h) {
        super(p.getX(), p.getY() - h);
        this.width = p.getWidth();
        this.height = h;
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
        g.drawImage(Assets.fire, getX(), getY(), getWidth(), getHeight(), null);
    }


}
