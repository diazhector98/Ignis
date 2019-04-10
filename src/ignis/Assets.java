/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.image.BufferedImage;

/**
 *
 * @author antoniomejorado
 */
public class Assets {
    public static BufferedImage background; // to store background image
    public static BufferedImage blueSquare;
    public static BufferedImage brownSquare;


    /**
     * initializing the images of the game
     */
    public static void init() {
        blueSquare = ImageLoader.loadImage("/images/BlueSquare.png");
        brownSquare = ImageLoader.loadImage("/images/BrownRectangle.png");
        background = ImageLoader.loadImage("/images/GrayRectangle.png");
    }
    
}
