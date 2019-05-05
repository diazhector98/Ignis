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
public class AtomAssets {
        
    public static void init() {
        
    }
    
    public static BufferedImage getAtomImage(String elemento){
        
        String file = "/images/atoms/" + elemento + "-atom.png";
        return ImageLoader.loadImage(file);
    }
}
