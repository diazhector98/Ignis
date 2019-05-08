/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.StoreAssets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class StoreObject {
    
    private String name;
    private String formula;
    private BufferedImage storeIcon;
    private Compound compound;
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean bought;
    
    public StoreObject(int x, int y, String n, String formula, int id, boolean bought){
        this.name = n;
        this.formula = formula;
        this.id = id;
        if(bought){
            this.storeIcon = StoreAssets.getImage(n);
        } else {
            this.storeIcon = StoreAssets.getDarkImage(n);
        }
        this.compound = new Compound(formula, n);
        this.x = x;
        this.y = y;
        this.width = 150;
        this.height = 150;
        this.bought = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    
    public BufferedImage getStoreIcon(){
        return storeIcon;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Compound getCompound() {
        return compound;
    }

    public void setCompound(Compound compound) {
        this.compound = compound;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.storeIcon = StoreAssets.getImage(name);
        this.bought = bought;
    }

    public void setStoreIcon(BufferedImage storeIcon) {
        this.storeIcon = storeIcon;
    }
    
    
    
    
    
    public void render(Graphics g){

    }
    
    
}
