/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.BuildingAssets;
import ignis.Assets.SoundAssets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class Lab extends Building {

    private Button backButton; // back button
    private Button doorsButton; // doors button
    private MouseManager mouseManager; // mouse manager
    private Graphics graphics; // game graphics
    private DoorScreen doorScreen; // Door screen
    private boolean onDoors; // if mouse is on door
    private int buttonTimer; // timer of the button
    
    /**
     *
     * @param x x position of the lab
     * @param y y position of the lab
     * @param width width of the lab
     * @param height height of the lab
     * @param g game object
     */
    public Lab(int x, int y, int width, int height, Game g) {
        super(x, y, width, height, BuildingAssets.lab, g);
        this.backButton = new Button(50, 50, 150, 150, "BACK", g);
        this.doorsButton = new Button(game.getWidth() - 250, 100, 185, 60, "DOORS", g);
        this.graphics = g.getG();
        this.mouseManager = new MouseManager();

        this.game.getDisplay().getJframe().addMouseListener(mouseManager);
        this.game.getDisplay().getJframe().addMouseMotionListener(mouseManager);
        this.game.getDisplay().getCanvas().addMouseListener(mouseManager);
        this.game.getDisplay().getCanvas().addMouseMotionListener(mouseManager);
        
        this.doorScreen = new DoorScreen(g);
        this.onDoors = false;
        
        this.buttonTimer = 0;

    }
    
    /**
     * Update lab to check if is clicked
     */
    public void tickLab() {
        if (mouseManager.isIzquierdo() && buttonTimer == 0) {
            buttonTimer = 25;
            int mouseX = mouseManager.getX();
            int mouseY = mouseManager.getY();
            if (posInButton(mouseX, mouseY, backButton)) {
                System.out.println("Back to menu");
                SoundAssets.click.play();
                game.setOnLab(false);
            }
            if(posInButton(mouseX, mouseY, doorsButton)){
                System.out.println("Doors clicked");
                onDoors = true;
            }
        }
    }
    
    /**
     * Update Doors to check if are clicked
     */
    public void tickDoors() {
        if (mouseManager.isIzquierdo() && buttonTimer == 0) {
            buttonTimer = 25;
            int mouseX = mouseManager.getX();
            int mouseY = mouseManager.getY();
            if (posInButton(mouseX, mouseY, backButton)) {
                onDoors = false;
            }
        }
    }
    
    /**
     *
     */
    public void render(){
        showBackground();
        if(!onDoors){
            renderLab();
        } else {
            renderDoors();
        }
    }
    
    /**
     *
     */
    public void renderLab() {
        showPeriodicTableTitle();
        showPeriodicTable();
        showBackButton();
        showDoorsButton();
    }
    
    /**
     *
     */
    public void renderDoors() {
        showBackButton();
        showDoors();
    }
    
    /**
     *
     */
    public void showBackground() {
        BufferedImage background = BuildingAssets.labBackground;
        game.getG().drawImage(background, 0, 0, game.getWidth(), game.getWidth(), null);
    }
    
    /**
     *
     */
    public void showPeriodicTableTitle() {
        game.getG().drawImage(BuildingAssets.periodicTableTitle,350,75,530,50,null);
    }
    
    /**
     *
     */
    public void showPeriodicTable() {
        game.getG().drawImage(BuildingAssets.periodicTable,150,175,950,575,null);
    }
    
    /**
     *
     */
    public void showBackButton() {
        backButton.render(game.getG());
    }
    
    /**
     *
     */
    public void showDoorsButton() {
        doorsButton.render(game.getG());
    }
    
    /**
     *
     */
    public void showDoors() {
        game.getG().drawImage(BuildingAssets.doors,190,190,950,575,null);
    }
    
    /**
     *
     */
    public void tick() {
        buttonTimer = buttonTimer > 0 ? buttonTimer - 1 : 0;
        if (onDoors) {
            tickDoors();
        } else {
            tickLab();
        }
    }
   
    private boolean posInButton(int x, int y, Button button) {
        int buttonX, buttonWidth, buttonY, buttonHeight;

        buttonX = button.getX();
        buttonWidth = button.getWidth();
        buttonY = button.getY();
        buttonHeight = button.getHeight();

        if (x < buttonX || x > buttonX + buttonWidth) {
            return false;
        }
        if (y < buttonY || y > buttonY + buttonHeight) {
            return false;
        }
        return true;
    }
    
    

}
