/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.MenuAssets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
/**
 *
 * @author rober
 */
public class Info {
    
    private int x;
    private int y;
    private int width; 
    private int height;
    private Game game;
    private BufferedImage image;
    
    public Info (int x, int y, int width, int height, Game game){
        this.x=x;
        this.y=y;
        this.width=width;
        this.game=game;
        image= MenuAssets.INFO;
        
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    
    
    
    
    
         public void render(Graphics g){
        g.drawImage(this.image, getX(), getY(), getWidth(), getHeight(), null);
    }
        
    
    
    
}
