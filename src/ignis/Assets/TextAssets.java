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
public class TextAssets {
    
    public static BufferedImage COMPUESTO;
    public static BufferedImage H20;
    
    
    public static void init(){
        COMPUESTO = ImageLoader.loadImage("/images/COMPUESTO.png");
        H20 = ImageLoader.loadImage("/images/H20.png");
    }
}
