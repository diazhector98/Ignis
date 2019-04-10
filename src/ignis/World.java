/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.Graphics;

/**
 *
 * @author hectordiazaceves
 */
public class World {
    
    private Player player;
    private Game game;
    
    World(Game g, Player p){
        this.game = g;
        this.player = p;
    }
    
    
    public void tick(){
    
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.greenSquare, 0, 0, game.getWidth(), game.getHeight(), null);
    }
}
