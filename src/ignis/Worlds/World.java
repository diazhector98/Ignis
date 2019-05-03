/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Worlds;

import ignis.Assets.Assets;
import ignis.Assets.TextAssets;
import ignis.Atom;
import ignis.Enemy;
import ignis.Fire;
import ignis.Game;
import ignis.Platform;
import ignis.Player;
import ignis.Robot;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author hectordiazaceves
 */
public abstract class World {
    
    protected Player player;
    protected Game game;
    protected int idWorld;
    protected LinkedList<Platform> map;
    protected String compuestoBuscar;
    protected LinkedList<Atom> atoms;
    protected int needAtoms = 3;
    protected LinkedList<Enemy> enemies;
    
    
    public World(Game g, Player p, int id) {
        this.idWorld = id;
        if (idWorld == 1) {
            needAtoms = 3;
        }
        this.game = g;
        this.player = p;
        map = new LinkedList<Platform>();
        atoms = new LinkedList<>();
        enemies = new LinkedList<>();
        
    }
    
    public void setIdWorld(int id){
        this.idWorld = id;
        
    }
    
    public void setCompuestoBuscar(String compuesto){
        this.compuestoBuscar = compuesto;
    }
    
    public String getColor(int red, int green, int blue){
        if(red == 255 && green == 255 && blue == 255){
            return "WHITE";
        } else if(red == 0 && green == 0 && blue == 0){
            return "BLACK";
        } else if(red > green && red > blue){
            return "RED";
        } else if(green > red && green > blue){
            return "GREEN";
        } else if(blue > green && blue > red){
            return "BLUE";
        } else {
            return "NOT DETECTED";
        }
    }
    
    public abstract void tick();
    public abstract void generateWorld();
    public abstract void render(Graphics g);
    
    public void gameOver(Graphics g)
    {
          g.drawImage(Assets.gameOver, 0, 0, game.getWidth(), game.getHeight(), null);
    }
}
