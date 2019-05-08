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
     * @param obj Object StoreObject
     * @param g Object Game 
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
     * @return background 
     */
    public BufferedImage getBackground() {
        return background;
    }

    /**
     *
     * @param background to set background 
     */
    public void setBackground(BufferedImage background) {
        this.background = background;
    }

    /**
     *
     * @return backbutton
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     *
     * @param backButton set backbutton 
     */
    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    /**
     *
     * @return StoreObject object 
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
     * @return object game
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game set object game
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    /**
     *
     * @return objecttitle
     */
    public BufferedImage getObjectTitle() {
        return objectTitle;
    }

    /**
     *
     * @param objectTitle set Objecttitle
     */
    public void setObjectTitle(BufferedImage objectTitle) {
        this.objectTitle = objectTitle;
    }

    /**
     *
     * @return object buybutton
     */
    public Button getBuyButton() {
        return buyButton;
    }

    /**
     *
     * @param buyButton set buybutton
     */
    public void setBuyButton(Button buyButton) {
        this.buyButton = buyButton;
    }
    
    /**
     *
     * @param g Graphics 
     */
    public void render(Graphics g){
        g.drawImage(background, 0, 0, game.getWidth(), game.getWidth(), null);
    }
    
    
    
}
