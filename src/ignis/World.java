/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.DataBufferByte;

/**
 *
 * @author hectordiazaceves
 */
public class World {
    
    private Player player;
    private Game game;
    private int idWorld;
    private String compuestoBuscar;
    
    World(Game g, Player p){
        this.game = g;
        this.player = p;
        
    }
    
    public void setIdWorld(int id){
        this.idWorld = id;
    }
    
    public void setCompuestoBuscar(String compuesto){
        this.compuestoBuscar = compuesto;
    }
    
    public void tick(){
    
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.backgroundMine, 0, 0, game.getWidth(), game.getHeight(), null);
        g.translate(-(player.getX()-1200/2), -(player.getY()-800/2));
        //g.drawImage(Assets.brownSquare,(player.getX())-600, (player.getY())-400,100,100,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 28));
        if(idWorld==1){
        compuestoBuscar = "H2O";
        g.setColor(Color.WHITE);
        g.drawString( "Compuesto", (player.getX())+600-150, (player.getY())-350-28);
        g.drawString( compuestoBuscar, (player.getX())+600-100, (player.getY())-350);
        }
    }
}
