/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Assets;

import ignis.ImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class BuildingAssets {
    
    public static BufferedImage store;
    public static BufferedImage lab;
    
    public static void init() {
        store = ImageLoader.loadImage("/images/store.png");
        lab = ImageLoader.loadImage("/images/lab.png");
    }
    
}
