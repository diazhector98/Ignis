/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.Graphics;

/**
 *
 * @author hectordiazaceves
 */
public class Door extends Item {
    
    private int direction;
    private int width;
    private int height;
    private Game game;

    public Door(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.brownSquare, getX(), getY(), getWidth(), getHeight(), null);
    }
}
