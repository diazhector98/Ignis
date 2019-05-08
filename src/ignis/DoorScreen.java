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
    
    /**DoorScreen
     * Door screen constructor
     * @param g
     */
    public DoorScreen (Game g){
        this.background = BuildingAssets.storeBackground;
        this.backButton = new Button(50,50,150,150,"BACK",g);
        this.game = g;
    }

    /**getBackground
     * Get the background image
     * @return BufferedImage of the door screen
     */
    public BufferedImage getBackground() {
        return background;
    }

    /** setBackground
     * Set the background image
     * @param background image
     */
    public void setBackground(BufferedImage background) {
        this.background = background;
    }

    /** getBackButton
     *  Get the back button 
     * @return Button
     */
    public Button getBackButton() {
        return backButton;
    }

    /**setBackButton
     * sets the back button
     * @param backButton
     */
    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    /**getDoorsImage
     * Gets the image of the door
     * @return Buffered image of the doors
     */
    public BufferedImage getDoorsImages() {
        return doorsImages;
    }

    /**setDoorsImages
     * Set the images of the doors
     * @param doorsImages
     */
    public void setDoorsImages(BufferedImage doorsImages) {
        this.doorsImages = doorsImages;
    }

    /** getGame
     * Get the game 
     * @return game 
     */
    public Game getGame() {
        return game;
    }

    /**setGame
     * Set the game
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    /**render
     * Render the image of the door screen
     * @param g
     */
    public void render(Graphics g){
        g.drawImage(background, 0, 0, game.getWidth(), game.getWidth(), null);
     }
    
    
    
}
