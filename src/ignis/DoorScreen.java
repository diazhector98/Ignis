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
    
    public DoorScreen (Game g){
        this.background = BuildingAssets.storeBackground;
        this.backButton = new Button(50,50,150,150,"BACK",g);
        this.game = g;
    }

    public BufferedImage getBackground() {
        return background;
    }

    public void setBackground(BufferedImage background) {
        this.background = background;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public BufferedImage getDoorsImages() {
        return doorsImages;
    }

    public void setDoorsImages(BufferedImage doorsImages) {
        this.doorsImages = doorsImages;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    public void render(Graphics g){
        g.drawImage(background, 0, 0, game.getWidth(), game.getWidth(), null);
     }
    
    
    
}
