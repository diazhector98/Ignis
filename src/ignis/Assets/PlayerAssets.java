/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Assets;

import ignis.ImageLoader;
import ignis.ImageLoader;
import ignis.SpreadSheet;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author hectordiazaceves
 */
public class PlayerAssets {
    public static BufferedImage playerRight;
    public static BufferedImage playerLeft;
    
    public static BufferedImage playerLeftImages[];
    public static BufferedImage playerRightImages[];
    public static BufferedImage playerFrontImages[];
    public static BufferedImage playerBackImages[];

    
    public static void init() {
        playerRight = ImageLoader.loadImage("/images/playerRight.png");
        playerLeft = ImageLoader.loadImage("/images/playerLeft.png");
        playerLeftImages = new BufferedImage[4];
        playerRightImages = new BufferedImage[4];
        playerFrontImages = new BufferedImage[4];
        playerBackImages = new BufferedImage[4];

        
        SpreadSheet playerLeftSheet = new SpreadSheet(ImageLoader.loadImage("/images/player/playerLeftSpreadsheet.png"));
        SpreadSheet playerRightSheet = new SpreadSheet(ImageLoader.loadImage("/images/player/playerRightSpreadsheet.png"));
        SpreadSheet playerFrontSheet = new SpreadSheet(ImageLoader.loadImage("/images/player/playerFrontSpreadsheet.png"));
        SpreadSheet playerBackSheet = new SpreadSheet(ImageLoader.loadImage("/images/player/playerBackSpreadsheet.png"));

        for(int i = 0; i < 4; i++){
            playerLeftImages[i] = playerLeftSheet.crop(0, i * 90,55 , 80);
            playerRightImages[i] = playerRightSheet.crop(0, i * 90,55 , 80);
            playerFrontImages[i] = playerFrontSheet.crop(0, i * 90,55 , 80);
            playerBackImages[i] = playerBackSheet.crop(0, i * 90,55 , 80);

        }
        
        
    }
}
