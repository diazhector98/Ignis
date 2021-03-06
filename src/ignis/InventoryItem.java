/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.AtomAssets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class InventoryItem {
    private BufferedImage atomIcon;
    private String symbol;
    private int quantity;
    private int x;
    private int y;
    private int height;
    private int width;
    
    public InventoryItem(int x, int y, int height, int width, String s, int qty){
        this.symbol = s;
        this.quantity = qty;
        this.atomIcon = AtomAssets.getAtomImage(s);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    public void render(Game game){
        game.getG().drawImage(atomIcon, x, y, width / 2, width / 2, null);
        game.getG().setFont(new Font("Arial", Font.PLAIN, 30));
        game.getG().setColor(Color.BLACK);  
        String atomQuantityString = Integer.toString(quantity);
        game.getG().drawString(atomQuantityString,  x + width / 2 + 10,y + height / 2);
    }
}
