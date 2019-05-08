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
    public static BufferedImage storeTitle;
    
    
    
    
    public static BufferedImage lab;
    
    
    public static BufferedImage labBackground;
    public static BufferedImage doors;
    public static BufferedImage periodicTable;
    public static BufferedImage periodicTableTitle;
    
    
        
    
    public static void init() {
        //Store
        store = getImage("store");
        storeBackground = getImage("storeBackground");
        storeTitle = getImage("storeTitle");
        lab = getImage("lab");
        
        labBackground = getLabImage("background");
        doors = getLabImage("doorsImage");
        periodicTable = getLabImage("periodicTable");
        periodicTableTitle = getLabImage("periodicTableTitle");
    }
    
    public static BufferedImage getImage(String s){
        String dir = getImageDirectory(s);
        return ImageLoader.loadImage(dir);
    }
    
    public static String getImageDirectory(String fileName){
        return "/images/buildings/" + fileName + ".png";
    }
    
    
    public static BufferedImage getLabImage(String s){
        String dir = getLabImageDirectory(s);
        return ImageLoader.loadImage(dir);
    }
    
    public static String getLabImageDirectory(String fileName){
            return "/images/laboratory/" + fileName + ".png";
    }
    
}
