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
     * @return int id 
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id int set id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return string name
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
     * @return int x 
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x int to set this x 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return int y 
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y int set this y 
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return int width 
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
     * @return int height 
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height Int to establish height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     *
     * @return BufferedImage storeIcon 
     */
    public BufferedImage getStoreIcon(){
        return storeIcon;
    }

    /**
     *
     * @return string formula
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
     * @return Object compound 
     */
    public Compound getCompound() {
        return compound;
    }

    /**
     *
     * @param compound Object Compund to set this compound 
     */
    public void setCompound(Compound compound) {
        this.compound = compound;
    }

    /**
     *
     * @return boolean bought 
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
     * @param storeIcon BufferedImage storeIcon to set storeIcon 
     */
    public void setStoreIcon(BufferedImage storeIcon) {
        this.storeIcon = storeIcon;
    }
    
    /**
     *
     * @param g Graphics 
     */
    public void render(Graphics g){

    }
    
    
}
