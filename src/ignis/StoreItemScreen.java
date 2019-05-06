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
public class StoreItemScreen {
    
    private BufferedImage background;
    private Button backButton;
    private StoreObject object;
    private BufferedImage objectTitle;
    private Button buyButton;
    private Game game;
    
    public StoreItemScreen(StoreObject obj, Game g){        
        this.background = BuildingAssets.storeBackground;
        this.backButton = new Button(50,50,150,150,"BACK",g);
        this.object = obj;
        this.objectTitle = StoreAssets.getTitleImage(obj.getName());
        this.buyButton = new Button(g.getWidth() - 500, g.getHeight() - 200, 350, 150, "BUY", g);
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

    public StoreObject getObject() {
        return object;
    }

    public void setObject(StoreObject object) {
        this.object = object;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    

    public BufferedImage getObjectTitle() {
        return objectTitle;
    }

    public void setObjectTitle(BufferedImage objectTitle) {
        this.objectTitle = objectTitle;
    }

    public Button getBuyButton() {
        return buyButton;
    }

    public void setBuyButton(Button buyButton) {
        this.buyButton = buyButton;
    }
    
    public void render(Graphics g){
        g.drawImage(background, 0, 0, game.getWidth(), game.getWidth(), null);
    }
    
    
    
}
