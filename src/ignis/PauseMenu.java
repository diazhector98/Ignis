/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Worlds.World;
import java.awt.Graphics;
import ignis.Assets.SoundAssets;
/**
 *
 * @author hectordiazaceves
 */
public class PauseMenu {
    
    private Game game;
    private Player player;
    private Button keepGoingButton;
    private Button goToMenuButton;
    private Button saveButton;
    private int MARGIN = 30;
    private MouseManager mouseManager;
    private World world;
    private Info info;
    
    /**
     *
     * @param g
     * @param p
     * @param w
     */
    public PauseMenu(Game g, Player p, World w){
        this.game = g;
        this.player = p;
        this.world = w;
        this.keepGoingButton = new Button(200 + MARGIN, 200 + MARGIN, 200, 100, "KEEPGOING", g);
        this.goToMenuButton = new Button(200 + MARGIN, 300 + MARGIN * 2, 200, 100, "GOTOMENU", g);
        this.info= new Info (400+MARGIN, 200 +MARGIN, 400,400,g);
        this.saveButton = new Button(200 + MARGIN, 400 + MARGIN * 3, 200, 100, "SAVE", g);
        this.mouseManager = new MouseManager();
                
        
        this.game.getDisplay().getJframe().addMouseListener(mouseManager);
        this.game.getDisplay().getJframe().addMouseMotionListener(mouseManager);
        this.game.getDisplay().getCanvas().addMouseListener(mouseManager);
        this.game.getDisplay().getCanvas().addMouseMotionListener(mouseManager);

        SoundAssets.init();
    }
    
    /**
     *
     */
    public void tick() {

        if (mouseManager.isIzquierdo()) {
            int mouseX = mouseManager.getX();
            int mouseY = mouseManager.getY();
            if (posInButton(mouseX, mouseY, keepGoingButton)) {
                System.out.println("Keep Going Pressed");
                SoundAssets.click.play();
                world.unPause();
            } else if (posInButton(mouseX, mouseY, goToMenuButton)) {
                SoundAssets.click.play();
                System.out.println("Go to Menu Pressed");
                world.returnToMenu();
                game.getUser().updateAtomQuantities(player.getAtoms());
                game.getUser().updateUserLives(player.getLives());
            } else if (posInButton(mouseX, mouseY, saveButton)) {
                SoundAssets.click.play();
                System.out.println("Save button Pressed");
                game.getUser().updateAtomQuantities(player.getAtoms());
                game.getUser().updateUserLives(player.getLives());
            }
        }

    }
    
    private boolean posInButton(int x, int y, Button b) {
        int buttonX, buttonWidth, buttonY, buttonHeight;

        buttonX = b.getX();
        buttonWidth = b.getWidth();
        buttonY = b.getY();
        buttonHeight = b.getHeight();

        if (x < buttonX || x > buttonX + buttonWidth) {
            return false;
        }
        if (y < buttonY || y > buttonY + buttonHeight) {
            return false;
        }
        return true;
    }
    
    /**
     *
     * @param g
     */
    public void render(Graphics g){
        this.info.render (g);
        this.keepGoingButton.render(g);
        this.goToMenuButton.render(g);
        this.saveButton.render(g);
        
        
    }
}
