/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.BuildingAssets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class Lab extends Building {

    private Button backButton;
    private Button doorsButton;
    private MouseManager mouseManager;
    private Graphics graphics;
    private DoorScreen doorScreen;
    private boolean onDoors;
    private int buttonTimer;
    

    
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
    
    public void tickLab(){
    
    }
    
    public void tickDoors() {
    
    }
    
    public void render(){
        showBackground();
        if(!onDoors){
            renderLab();
        } else {
            renderDoors();
        }
    }
    
    public void renderLab() {
        showPeriodicTableTitle();
        showPeriodicTable();
        showBackButton();
        showDoorsButton();
    }
    
    public void renderDoors() {
        
    }
    
    public void showBackground() {
        BufferedImage background = BuildingAssets.labBackground;
        game.getG().drawImage(background, 0, 0, game.getWidth(), game.getWidth(), null);
    }
    
    public void showPeriodicTableTitle() {
        game.getG().drawImage(BuildingAssets.periodicTableTitle,350,75,530,50,null);
    }
    
    public void showPeriodicTable() {
        game.getG().drawImage(BuildingAssets.periodicTable,150,175,950,575,null);
    }
    
    public void showBackButton() {
        backButton.render(game.getG());
    }
    
    public void showDoorsButton() {
        doorsButton.render(game.getG());
    }
    
    public void tick() {
        buttonTimer = buttonTimer > 0 ? buttonTimer - 1 : 0;
        if (onDoors) {
            tickDoors();
        } else {
            tickLab();
        }
    }
    
    

}
