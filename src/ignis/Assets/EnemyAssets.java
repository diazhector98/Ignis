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
    public static BufferedImage SLIME_LEFT;
    public static BufferedImage SLIME_RIGHT;
    public static BufferedImage GHOST_LEFT;
    public static BufferedImage GHOST_RIGHT;
    
    public static ArrayList<Pair> enemiesImages;
    
    public static void init() {
        enemiesImages = new ArrayList<>();
        
        ROBOT_LEFT = ImageLoader.loadImage("/images/enemies/enemy1_left.png");
        ROBOT_RIGHT = ImageLoader.loadImage("/images/enemies/enemy1_right.png");
        ENEMY2_RIGHT = ImageLoader.loadImage("/images/enemies/enemy2_right.png");
        ENEMY2_LEFT = ImageLoader.loadImage("/images/enemies/enemy2_left.png");
        SLIME_LEFT = ImageLoader.loadImage("/images/enemies/enemy3_left.png");
        SLIME_RIGHT = ImageLoader.loadImage("/images/enemies/enemy3_right.png");
        GHOST_LEFT = ImageLoader.loadImage("/images/enemies/enemy6_left.png");
        GHOST_RIGHT = ImageLoader.loadImage("/images/enemies/enemy6_right.png");


        Pair robot = new Pair(ROBOT_LEFT, ROBOT_RIGHT);
        Pair enemy2 = new Pair(ENEMY2_RIGHT, ENEMY2_LEFT);
        Pair slime = new Pair(SLIME_LEFT,SLIME_RIGHT);
        Pair ghost = new Pair(GHOST_LEFT, GHOST_RIGHT);
        enemiesImages.add(robot);
        enemiesImages.add(enemy2);
        enemiesImages.add(slime);
        enemiesImages.add(ghost);

    }
    
    public static Pair getEnemyImages(int index){
        return enemiesImages.get(index);
    }
}
