/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.LinkedList;

/**
 *
 * @author hectordiazaceves
 */
public class World {
    
    private Player player;
    private Game game;
    private int idWorld;
    private BufferedImage mapImage;
    private LinkedList<Platform> map;
    
    World(Game g, Player p, int id){
        map = new LinkedList<Platform>();
        this.game = g;
        this.player = p;
        switch(id){
            case 1: mapImage=Assets.level2;
            case 2: mapImage=Assets.level2;
            default: mapImage=Assets.level2;
        }
        for (int xx = 0; xx < 84; xx++) {
            for (int yy = 0; yy < 17; yy++) {
                int pixel = mapImage.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (red == 255 && green == 255 && blue == 255) {
                    map.add(new Platform(xx * 32, yy * 32, 32, 32));
                };
            }
        }
    }
    
    
    public void tick(){
        for (int i = 0; i < map.size(); i++) {
                map.get(i).tick();
            }
    
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.greenSquare, 0, 0, game.getWidth(), game.getHeight(), null);
        g.translate(-(player.getX()-1200/2), -(player.getY()-800)/2);
        for (int i = 0; i < map.size(); i++) {
                map.get(i).render(g);
            }
        
    }
}
