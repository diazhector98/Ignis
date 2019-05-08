/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Assets;
import ignis.SoundClip;
import java.awt.image.BufferedImage;
/**
 *
 * @author Jorge
 */
public class SoundAssets {
    public static SoundClip puerta; 
    public static SoundClip click;
    public static SoundClip tienda;
    public static SoundClip maintheme;
    public static SoundClip death;
    public static SoundClip atom;
    public static SoundClip hit;
     public static SoundClip gameover;
    
       public static void init() {
        puerta = new SoundClip("/Sounds/death.wav");
        click = new SoundClip("/Sounds/click.wav");
        tienda = new SoundClip("/Sounds/shop.wav");
        maintheme = new SoundClip("/Sounds/maintheme.wav");
        death = new SoundClip("/Sounds/death.wav");
        atom = new SoundClip("/Sounds/atom.wav");
        hit = new SoundClip("/Sounds/hit.wav");
         gameover = new SoundClip("/Sounds/gameover.wav");
    }
}
