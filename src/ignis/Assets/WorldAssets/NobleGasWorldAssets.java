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
public class NobleGasWorldAssets {
    public static BufferedImage block;
    public static BufferedImage background;
    public static BufferedImage world;
    
    public static void init() {
        block = ImageLoader.loadImage("/images/worlds/block9.png");
        background = ImageLoader.loadImage("/images/NobleGasbck.jpg");
        world = ImageLoader.loadImage("/images/worlds/world9.png");
    }
}
