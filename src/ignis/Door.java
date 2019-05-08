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
    
    private int direction; /// direction of the door
    private int width; // width of the door
    private int height; /// height of the door
    private BufferedImage image; // image of the door
    private Game game; // game
    private int index; // identifier of the specific dooor 

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
    
    /**getWidth
     *Get the width of the door
     * @return <int>width of the the door
     */
    public int getWidth(){
        return width;
    }
    
    /**getHeight
     *Get the height of the door
     * @return<int> height of the door
     */
    public int getHeight(){
        return height;
    }

    /**getIndex
     *Get the index of the door
     * @return<int> identifier of the door
     */
    public int getIndex() {
        return index;
    }

    /**setIndex
     * Set the Index
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
    /**getPerimetro
     *Get the perimetro 
     * @return Rectangle
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void tick() {
    }
    /**render
     * Render the door
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(this.image, getX(), getY(), getWidth(), getHeight(), null);
    }
}
