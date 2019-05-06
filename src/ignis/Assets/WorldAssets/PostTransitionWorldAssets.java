/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Assets.WorldAssets;

import ignis.ImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class PostTransitionWorldAssets {
    public static BufferedImage block;
    public static BufferedImage background;
    public static BufferedImage world;
    
    public static void init() {
        block = ImageLoader.loadImage("/images/worlds/block6.png");
        background = ImageLoader.loadImage("/images/bg6.png");
        world = ImageLoader.loadImage("/images/worlds/world6.png");
    }
}
