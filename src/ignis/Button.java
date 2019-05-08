/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.MenuAssets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class Button {
    
    private String text;
    private Game game;
    private BufferedImage image;
    private int x;
    private int y;
    private int width;
    private int height;
    
    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param s
     * @param g
     */
    public Button(int x, int y, int width, int height, String s, Game g){
        this.text = s;
        this.game = g;
        this.image = MenuAssets.getButton(s);
        this.x = x;
        this.y = y;
        this.width = width;
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
     */
    public void tick() {
    
    }
    
    /**
     *
     * @param g
     */
    public void render(Graphics g){
        g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

}
