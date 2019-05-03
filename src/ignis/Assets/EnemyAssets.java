/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Assets;

import ignis.ImageLoader;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author hectordiazaceves
 */
public class EnemyAssets {
    
    public static BufferedImage ROBOT_LEFT;
    public static BufferedImage ROBOT_RIGHT;
    
    
    public static ArrayList<Pair> enemiesImages;
    
    public static void init() {
        enemiesImages = new ArrayList<>();
        
        ROBOT_LEFT = ImageLoader.loadImage("/images/enemies/enemy1_left.png");
        ROBOT_RIGHT = ImageLoader.loadImage("/images/enemies/enemy1_right.png");
        Pair robot = new Pair(ROBOT_LEFT, ROBOT_RIGHT);
        enemiesImages.add(robot);
        
        
    }
    
    public static Pair getEnemyImages(int index){
        return enemiesImages.get(index);
    }
}
