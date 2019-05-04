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
    
    public static BufferedImage hydrogenAtom;
    public static BufferedImage oxygenAtom;
    
    public static void init() {
        hydrogenAtom = ImageLoader.loadImage("/images/hydrogenAtom.png");
        oxygenAtom = ImageLoader.loadImage("/images/oxygenAtom.png");
    }
    
    public BufferedImage getAtomImage(String elemento){
        return null;
    }
}
