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
    
    /**
     *
     * @param x
     * @param y
     * @param n
     * @param formula
     * @param id
     * @param bought
     */
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

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @return
     */
    public BufferedImage getStoreIcon(){
        return storeIcon;
    }

    /**
     *
     * @return
     */
    public String getFormula() {
        return formula;
    }

    /**
     *
     * @param formula
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     *
     * @return
     */
    public Compound getCompound() {
        return compound;
    }

    /**
     *
     * @param compound
     */
    public void setCompound(Compound compound) {
        this.compound = compound;
    }

    /**
     *
     * @return
     */
    public boolean isBought() {
        return bought;
    }

    /**
     *
     * @param bought
     */
    public void setBought(boolean bought) {
        this.storeIcon = StoreAssets.getImage(name);
        this.bought = bought;
    }

    /**
     *
     * @param storeIcon
     */
    public void setStoreIcon(BufferedImage storeIcon) {
        this.storeIcon = storeIcon;
    }
    
    /**
     *
     * @param g
     */
    public void render(Graphics g){

    }
    
    
}
