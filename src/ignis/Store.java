/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.BuildingAssets;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class Store extends Building{
    
    public Store(int x, int y, int width, int height, Game g) {
        super(x, y, width, height, BuildingAssets.store, g);
    }
    
    public void showStore(){
        
    }
    
}
