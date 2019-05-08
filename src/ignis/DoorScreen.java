/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.BuildingAssets;
import ignis.Assets.StoreAssets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class DoorScreen {
    private BufferedImage background;
    private Button backButton;
    private BufferedImage doorsImages;
    private Game game;
    
    /**
     *
     * @param g
     */
    public DoorScreen (Game g){
        this.background = BuildingAssets.storeBackground;
        this.backButton = new Button(50,50,150,150,"BACK",g);
        this.game = g;
    }

    /**
     *
     * @return
     */
    public BufferedImage getBackground() {
        return background;
    }

    /**
     *
     * @param background
     */
    public void setBackground(BufferedImage background) {
        this.background = background;
    }

    /**
     *
     * @return
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     *
     * @param backButton
     */
    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    /**
     *
     * @return
     */
    public BufferedImage getDoorsImages() {
        return doorsImages;
    }

    /**
     *
     * @param doorsImages
     */
    public void setDoorsImages(BufferedImage doorsImages) {
        this.doorsImages = doorsImages;
    }

    /**
     *
     * @return
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    /**
     *
     * @param g
     */
    public void render(Graphics g){
        g.drawImage(background, 0, 0, game.getWidth(), game.getWidth(), null);
     }
    
    
    
}
