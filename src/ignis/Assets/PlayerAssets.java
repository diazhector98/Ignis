/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Assets;

import ignis.ImageLoader;
import ignis.ImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class PlayerAssets {
    public static BufferedImage playerRight;
    public static BufferedImage playerLeft;
    
    public static void init() {
        playerRight = ImageLoader.loadImage("/images/playerRight.png");
        playerLeft = ImageLoader.loadImage("/images/playerLeft.png");
    }
}
