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
    public static BufferedImage storeBackground;
    
    
    public static BufferedImage lab;
    
    
    
    public static void init() {
        //Store
        store = getImage("store");
        storeBackground = getImage("storeBackground");
        lab = getImage("lab");
    }
    
    public static BufferedImage getImage(String s){
        String dir = getImageDirectory(s);
        return ImageLoader.loadImage(dir);
    }
    
    public static String getImageDirectory(String fileName){
        return "/images/buildings/" + fileName + ".png";
    }
    
}
