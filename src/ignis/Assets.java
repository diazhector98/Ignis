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
    public static BufferedImage greenSquare;
    public static BufferedImage darkGraySquare;
    public static BufferedImage redSquare;
    public static BufferedImage purpleCircle;
    public static BufferedImage level1;    
    public static BufferedImage altLevel1;
    public static BufferedImage groundBlock;
    public static BufferedImage backgroundMine;
    public static BufferedImage playerRight;
    public static BufferedImage playerLeft;
    public static BufferedImage hydrogenAtom;
    public static BufferedImage oxygenAtom;
    public static BufferedImage win;



    /**
     * initializing the images of the game
     */
    public static void init() {
        blueSquare = ImageLoader.loadImage("/images/BlueSquare.png");
        brownSquare = ImageLoader.loadImage("/images/BrownRectangle.png");
        greenSquare = ImageLoader.loadImage("/images/GreenRectangle.png");
        redSquare = ImageLoader.loadImage("/images/RedRectangle.png");
        darkGraySquare = ImageLoader.loadImage("/images/DarkGrayRectangle.png");
        purpleCircle = ImageLoader.loadImage("/images/PurpleCircle.png");
        level1 = ImageLoader.loadImage("/images/level1.png");
        background = ImageLoader.loadImage("/images/GrayRectangle.png");
        altLevel1 = ImageLoader.loadImage("/images/altLevel1.png");
        groundBlock = ImageLoader.loadImage("/images/groundBlock.png");
        backgroundMine = ImageLoader.loadImage("/images/backgroundMine.png");
        playerRight = ImageLoader.loadImage("/images/playerRight.png");
        playerLeft = ImageLoader.loadImage("/images/playerLeft.png");
        hydrogenAtom = ImageLoader.loadImage("/images/hydrogenAtom.png");
        oxygenAtom = ImageLoader.loadImage("/images/oxygenAtom.png");
        win = ImageLoader.loadImage("/images/win.png");
        
    }
    
}
