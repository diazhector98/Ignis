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
    
    /**
     *
     * @param obj
     * @param g
     */
    public StoreItemScreen(StoreObject obj, Game g){        
        this.background = BuildingAssets.storeBackground;
        this.backButton = new Button(50,50,150,150,"BACK",g);
        this.object = obj;
        this.objectTitle = StoreAssets.getTitleImage(obj.getName());
        this.buyButton = new Button(g.getWidth() - 500, g.getHeight() - 200, 350, 150, "BUY", g);
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
    public StoreObject getObject() {
        return object;
    }

    /**
     *
     * @param object
     */
    public void setObject(StoreObject object) {
        this.object = object;
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
     * @return
     */
    public BufferedImage getObjectTitle() {
        return objectTitle;
    }

    /**
     *
     * @param objectTitle
     */
    public void setObjectTitle(BufferedImage objectTitle) {
        this.objectTitle = objectTitle;
    }

    /**
     *
     * @return
     */
    public Button getBuyButton() {
        return buyButton;
    }

    /**
     *
     * @param buyButton
     */
    public void setBuyButton(Button buyButton) {
        this.buyButton = buyButton;
    }
    
    /**
     *
     * @param g
     */
    public void render(Graphics g){
        g.drawImage(background, 0, 0, game.getWidth(), game.getWidth(), null);
    }
    
    
    
}
