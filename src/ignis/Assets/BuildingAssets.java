/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Assets;

import ignis.Database;
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
        Database d = new Database();

        //Store
        d.insertIntoErrorMessage("Init start for building assets");

        store = getImage("store");
        storeBackground = getImage("storeBackground");
        d.insertIntoErrorMessage("Init  building assets break 2");
        storeTitle = getImage("storeTitle");
        lab = getImage("lab");

        d.insertIntoErrorMessage("Init break normal images");

        labBackground = getLabImage("background");
        doors = getLabImage("doorsImage");
        periodicTable = getLabImage("periodicTable");
        periodicTableTitle = getLabImage("periodicTableTitle");

        d.insertIntoErrorMessage("Init break lab images");

        d.insertIntoErrorMessage("Init done for building assets");

    }
    
    public static BufferedImage getImage(String s){
        String dir = getImageDirectory(s);
        return ImageLoader.loadImage(dir);
    }
    
    public static String getImageDirectory(String fileName){
        return "/images/Buildings/" + fileName + ".png";
    }
    
    
    public static BufferedImage getLabImage(String s){
        String dir = getLabImageDirectory(s);
        return ImageLoader.loadImage(dir);
    }
    
    public static String getLabImageDirectory(String fileName){
            return "/images/laboratory/" + fileName + ".png";
    }
    
}
