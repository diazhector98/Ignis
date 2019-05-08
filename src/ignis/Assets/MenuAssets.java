/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Assets;

import ignis.ImageLoader;
import ignis.ImageLoader;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author hectordiazaceves
 */
public class MenuAssets {

    //Doors
    public static BufferedImage BACKGROUND;
    public static BufferedImage ALKALI_DOOR;
    public static BufferedImage ALKALINE_DOOR;
    public static BufferedImage LANTHANOIDS_DOOR;
    public static BufferedImage ACTINOIDS_DOOR;
    public static BufferedImage METALLOIDS_DOOR;
    public static BufferedImage NOBLEGASES_DOOR;
    public static BufferedImage NONMETALS_DOOR;
    public static BufferedImage POSTTRANSITIONAL_DOOR;
    public static BufferedImage TRANSITION_DOOR;

    private static ArrayList<BufferedImage> doors;

    //Buttons
    public static BufferedImage KEEPGOING_BUTTON;
    public static BufferedImage GOTOMENU_BUTTON;
    public static BufferedImage SAVE_BUTTON;
    public static BufferedImage BACK_BUTTON;
    public static BufferedImage BUY_BUTTON;
    public static BufferedImage DOORS_BUTTON;
   

    //Titles
    public static BufferedImage PAUSE_TITLE;
    
    //Instuctions
     public static BufferedImage INFO;
    public static BufferedImage INVENTORY_TOGGLE;

    public static void init() {
        BACKGROUND = ImageLoader.loadImage("/images/MenuBackground.png");

        ALKALI_DOOR = ImageLoader.loadImage("/images/doors/AlkaliDoor.png");
        ALKALINE_DOOR = ImageLoader.loadImage("/images/doors/AlkalineDoor.png");
        LANTHANOIDS_DOOR = ImageLoader.loadImage("/images/doors/LanthanoidsDoor.png");
        ACTINOIDS_DOOR = ImageLoader.loadImage("/images/doors/ActinoidsDoor.png");
        METALLOIDS_DOOR = ImageLoader.loadImage("/images/doors/MetalloidsDoor.png");
        NOBLEGASES_DOOR = ImageLoader.loadImage("/images/doors/NobleDoor.png");
        NONMETALS_DOOR = ImageLoader.loadImage("/images/doors/NonMetalsDoor.png");
        POSTTRANSITIONAL_DOOR = ImageLoader.loadImage("/images/doors/PostTransitionDoor.png");
        TRANSITION_DOOR = ImageLoader.loadImage("/images/doors/TransitionDoor.png");
        

        doors = new ArrayList<>();
        doors.add(ALKALI_DOOR);
        doors.add(ALKALINE_DOOR);
        doors.add(LANTHANOIDS_DOOR);
        doors.add(ACTINOIDS_DOOR);
        doors.add(METALLOIDS_DOOR);
        doors.add(NOBLEGASES_DOOR);
        doors.add(NONMETALS_DOOR);
        doors.add(POSTTRANSITIONAL_DOOR);
        doors.add(TRANSITION_DOOR);

        KEEPGOING_BUTTON = ImageLoader.loadImage("/images/buttons/keepGoingButton.png");
        GOTOMENU_BUTTON = ImageLoader.loadImage("/images/buttons/goToMenuButton.png");
        SAVE_BUTTON = ImageLoader.loadImage("/images/buttons/saveButton.png");
        BACK_BUTTON = ImageLoader.loadImage("/images/buttons/backButton.png");
        BUY_BUTTON = ImageLoader.loadImage("/images/store/buyButton.png");
        DOORS_BUTTON = ImageLoader.loadImage("/images/buttons/doorsButton.png");
        PAUSE_TITLE = ImageLoader.loadImage("/images/titles/pauseTitle.png");
<<<<<<< HEAD
        INFO=ImageLoader.loadImage ("/images/titles/Instructions.png");
=======
        INVENTORY_TOGGLE = ImageLoader.loadImage("/images/titles/toggleInventory.png");
>>>>>>> master
        

    }

    public static BufferedImage getDoor(int index) {
        return doors.get(index - 1);
    }
    
    public static BufferedImage getButton(String s){
        if(s.equals("KEEPGOING")) return KEEPGOING_BUTTON;
        if(s.equals("GOTOMENU")) return GOTOMENU_BUTTON;
        if(s.equals("SAVE")) return SAVE_BUTTON;
        if(s.equals("BACK")) return BACK_BUTTON;
        if(s.equals("BUY")) return BUY_BUTTON;
        if(s.equals("DOORS")) return DOORS_BUTTON;
        
        return null;
    }
}
