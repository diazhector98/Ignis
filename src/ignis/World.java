/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.Assets;
import ignis.Assets.WorldAssets;
import ignis.Assets.TextAssets;
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
public class World {
    
    private Player player;
    private Game game;
    private int idWorld;
    private LinkedList<Platform> map;
    private String compuestoBuscar;
    private Atom atom;
    private LinkedList<Atom> atoms;
    private int needAtoms = 3;
    private Fire fire;
    private LinkedList<Enemy> enemies;
    
    
    World(Game g, Player p){
        if (idWorld == 1){
            needAtoms = 3;
        }
        this.game = g;
        this.player = p;
        map = new LinkedList<Platform>();
        atoms = new LinkedList<>();
        enemies = new LinkedList<>();
        generateWorld();
        /// Init variables ///
        
        
    }
    
    public void setIdWorld(int id){
        this.idWorld = id;
        
    }
    
    public void setCompuestoBuscar(String compuesto){
        this.compuestoBuscar = compuesto;
    }
    
    public void tick(){
        ArrayList<Atom> atomsToRemove = new ArrayList<>();
        for(Atom a : atoms){
            a.tick();
            if(player.intersectsAtom(a)){
                atomsToRemove.add(a);
                needAtoms--;
            }
        }
        
        for(Atom a : atomsToRemove){
            atoms.remove(a);
        }
        atomsToRemove.clear();
        for (int i = 0; i < map.size(); i++) {
            player.handlePlatformIntersection(map.get(i));
        }
        if(player.intersectsAnyPlatformFromTheLeft(map)){
            player.setOnPlatformLeft(true);
        } else {
            player.setOnPlatformLeft(false);
        }
        if(player.intersectsAnyPlatformFromTheRight(map)){
            player.setOnPlatformRight(true);
        } else {
            player.setOnPlatformRight(false);
        }
        
        
        
        for(Platform p : map){
            p.tick();
        }
        
        for(Enemy e : enemies){
            e.tick();
            if(player.intersectsEnemy(e) && !player.isInvincible()){
                player.setInvincibilityTimer(150);
                player.loseALife();
            }
        }
        
        if(fire != null){
            fire.tick();
        }
        
        //Si el jugador encuentra todos los atomos
        
    
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

    public void generateWorld() {
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 30; x++) {
                int pixel = Assets.altLevel1.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (getColor(red, green, blue).equals("WHITE")) {
                    map.add(new Platform(x * 100, y * 100, 100, 100, "STATIC"));
                } else if (getColor(red, green, blue).equals("GREEN")) {
                    map.add(new Platform(x * 100, y * 100, 100, 100, "ACTIVE"));
                }
            }
        }

        Atom hydrogenAtom = new Atom(game, map.get(2), "H");
        Atom oxygenAtom = new Atom(game, map.get(5), "O");
        Atom oxygenAtom2 = new Atom(game, map.get(19), "O");

        atoms.add(hydrogenAtom);
        atoms.add(oxygenAtom);
        atoms.add(oxygenAtom2);

        Robot robot = new Robot(map.get(4));
        
        enemies.add(robot);

        fire = new Fire(map.get(25), 50, 70);

    }
    
    public void render(Graphics g){
        g.drawImage(Assets.darkGraySquare, 0, 0, game.getWidth(), game.getHeight(), null);
        g.translate(-(player.getX()-1200/2), -(player.getY()-800/2));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 28));
        if(idWorld==1){
            compuestoBuscar = "H2O";
            g.setColor(Color.WHITE);
            
            g.drawImage(TextAssets.COMPUESTO, (player.getX())+600-200, (player.getY())-350-28,170,40, null);
            for(int i=0;i<player.getLives();i++)
            {
            g.drawImage(Assets.heart, (player.getX())-580+i*30, (player.getY())-350-45,20,20, null);
            }
            
            g.drawImage(TextAssets.H20, (player.getX())+600-150, (player.getY())-320,100,40, null);

            //g.drawString( compuestoBuscar, (player.getX())+600-100, (player.getY())-350);
        }
        for(Atom a : atoms){
                a.render(g);
            }
        for (int i = 0; i < map.size(); i++) {
            map.get(i).render(g);
        }
        
        for(Enemy e : enemies){
            e.render(g);
        }
        if(fire != null){
            fire.render(g);
        }
        if (needAtoms<=0) {
            game.setWin(true);
            g.drawImage(Assets.win,(player.getX())-600, (player.getY())-400, game.getWidth(), game.getHeight(), null);
            //g.drawString( "You Won!", (player.getX()), (player.getY()));
        }
        
    }
    public void gameOver(Graphics g)
    {
          g.drawImage(Assets.gameOver, 0, 0, game.getWidth(), game.getHeight(), null);
    }
}
