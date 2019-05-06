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
    public static BufferedImage ENEMY2_RIGHT;
    public static BufferedImage ENEMY2_LEFT; 

    
    public static ArrayList<Pair> enemiesImages;
    
    public static void init() {
        enemiesImages = new ArrayList<>();
        
        ROBOT_LEFT = ImageLoader.loadImage("/images/enemies/enemy1_left.png");
        ROBOT_RIGHT = ImageLoader.loadImage("/images/enemies/enemy1_right.png");
        ENEMY2_RIGHT = ImageLoader.loadImage("/images/enemies/enemy2_right.png");
        ENEMY2_LEFT = ImageLoader.loadImage("/images/enemies/enemy2_left.png");
        Pair robot = new Pair(ROBOT_LEFT, ROBOT_RIGHT);
        Pair enemy2 = new Pair(ENEMY2_RIGHT, ENEMY2_LEFT);
        enemiesImages.add(robot);
        enemiesImages.add(enemy2);
        
  
        
        
    }
    
    public static Pair getEnemyImages(int index){
        return enemiesImages.get(index);
    }
}
