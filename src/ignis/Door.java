/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.Assets;
import ignis.Assets.MenuAssets;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class Door extends Item {
    
    private int direction;
    private int width;
    private int height;
    private BufferedImage image;
    private Game game;
    private int index;

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game
     * @param index
     */
    public Door(int x, int y, int width, int height, Game game, int index) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.image = MenuAssets.getDoor(index);
        this.index = index;
    }
    
    /**
     *
     * @return
     */
    public int getWidth(){
        return width;
    }
    
    /**
     *
     * @return
     */
    public int getHeight(){
        return height;
    }

    /**
     *
     * @return
     */
    public int getIndex() {
        return index;
    }

    /**
     *
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
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
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.image, getX(), getY(), getWidth(), getHeight(), null);
    }
}
