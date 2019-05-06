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
public class StoreAssets {
    
    
    public static BufferedImage waterIcon;
    public static BufferedImage saltIcon;
    
        
    
    public static void init() {
        waterIcon = getImage("water");
        saltIcon = getImage("salt");
    }
    
    public static BufferedImage getImage(String s){
        String dir = getImageDirectory(s);
        return ImageLoader.loadImage(dir);
    }
    
    public static String getImageDirectory(String fileName){
        return "/images/store/" + fileName + "StoreIcon.png";
    }
}
