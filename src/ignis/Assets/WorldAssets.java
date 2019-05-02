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
public class WorldAssets {
    
    public static BufferedImage groundBlock;
    public static BufferedImage backgroundMine;
    
    public static void init() {
        groundBlock = ImageLoader.loadImage("/images/groundBlock.png");
        backgroundMine = ImageLoader.loadImage("/images/backgroundMine.png");
    }
}
