/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Worlds;

import ignis.Assets.Assets;
import ignis.Assets.TextAssets;
import ignis.Assets.WorldAssets.LanthanoidWorldAssets;
import ignis.Atom;
import ignis.Enemy;
import ignis.Game;
import ignis.Platform;
import ignis.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author hectordiazaceves
 */
public class LanthanoidWorld extends World {

    public LanthanoidWorld(Game g, Player p) {
        super(g, p, 3);
        LanthanoidWorldAssets.init();
    }

    @Override
    public void tick() {
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

    }

    @Override
    public void generateWorld() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 12; x++) {
                int pixel = LanthanoidWorldAssets.world.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (getColor(red, green, blue).equals("WHITE")) {
                    map.add(new Platform(x * 100, y * 100, 100, 100, "STATIC", LanthanoidWorldAssets.block));
                } else if (getColor(red, green, blue).equals("GREEN")) {
                    map.add(new Platform(x * 100, y * 100, 100, 100, "ACTIVE", LanthanoidWorldAssets.block));
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.darkGraySquare, 0, 0, game.getWidth(), game.getHeight(), null);
        g.translate(-(player.getX()-1200/2), -(player.getY()-800/2));
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
        if (needAtoms<=0) {
            game.setWin(true);
            g.drawImage(Assets.win,(player.getX())-600, (player.getY())-400, game.getWidth(), game.getHeight(), null);
            //g.drawString( "You Won!", (player.getX()), (player.getY()));
        } 
    }
    
}
