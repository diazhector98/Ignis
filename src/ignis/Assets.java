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
    public static BufferedImage player;     // to store the player image
    public static BufferedImage bad;
    public static SoundClip bottleSound;           //to store the sound
    public static SoundClip loseSound;
    

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/background.png");
        player = ImageLoader.loadImage("/images/bin.png");
        bad = ImageLoader.loadImage("/images/bottle.png");
        bottleSound = new SoundClip("/sounds/plastic.wav");
        loseSound = new SoundClip("/sounds/lose.wav");
    }
    
}
