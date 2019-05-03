/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Worlds;

import ignis.Assets.Assets;
import ignis.Assets.TextAssets;
import ignis.Assets.WorldAssets.AlkaliWorldAssets;
import ignis.Atom;
import ignis.Enemy;
import ignis.Game;
import ignis.Platform;
import ignis.Player;
import ignis.Robot;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author hectordiazaceves
 */
public class AlkaliWorld extends World {
    
    public AlkaliWorld(Game g, Player p) {
        super(g, p, 1);
        AlkaliWorldAssets.init();
    }
    
    @Override
    public void generateWorld() {
        System.out.println("Generating alkali world");
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 30; x++) {
                int pixel = AlkaliWorldAssets.world.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (getColor(red, green, blue).equals("WHITE")) {
                    platforms.add(new Platform(x * 100, y * 100, 100, 100, "STATIC", AlkaliWorldAssets.block));
                } else if (getColor(red, green, blue).equals("GREEN")) {
                    platforms.add(new Platform(x * 100, y * 100, 100, 100, "ACTIVE", AlkaliWorldAssets.block));
                }
            }
        }

        Atom hydrogenAtom = new Atom(game, platforms.get(2), "H");
        Atom oxygenAtom = new Atom(game, platforms.get(5), "O");
        Atom oxygenAtom2 = new Atom(game, platforms.get(19), "O");

        atoms.add(hydrogenAtom);
        atoms.add(oxygenAtom);
        atoms.add(oxygenAtom2);

        Robot robot = new Robot(platforms.get(4));
        
        enemies.add(robot);
    }
    
    @Override
    public void tick() {
        
        
        if(!paused){
            
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
            for (int i = 0; i < platforms.size(); i++) {
                player.handlePlatformIntersection(platforms.get(i));
            }
            if(player.intersectsAnyPlatformFromTheLeft(platforms)){
                player.setOnPlatformLeft(true);
            } else {
                player.setOnPlatformLeft(false);
            }
            if(player.intersectsAnyPlatformFromTheRight(platforms)){
                player.setOnPlatformRight(true);
            } else {
                player.setOnPlatformRight(false);
            }



            for(Platform p : platforms){
                p.tick();
            }

            for(Enemy e : enemies){
                e.tick();
                if(player.intersectsEnemy(e) && !player.isInvincible()){
                    player.setInvincibilityTimer(150);
                    player.loseALife();
                }
            }
            
            if(game.getKeyManager().space){
                paused = true;
            }
        } else {
            pauseMenu.tick();
        }
                
    }

    @Override
    public void render(Graphics g) {

        if (!paused) {        
            
            g.drawImage(Assets.darkGraySquare, 0, 0, game.getWidth(), game.getHeight(), null);
            g.translate(-(player.getX() - 1200 / 2), -(player.getY() - 800 / 2));

            compuestoBuscar = "H2O";
            g.setColor(Color.WHITE);
            g.drawImage(TextAssets.COMPUESTO, (player.getX()) + 600 - 200, (player.getY()) - 350 - 28, 170, 40, null);
            g.drawImage(TextAssets.H20, (player.getX()) + 600 - 150, (player.getY()) - 320, 100, 40, null);

            renderPlayerLives(g);
            renderAtoms(g);
            renderPlatforms(g);
            renderEnemies(g);
            renderPlayer(g);
            

        } else {
            showPauseMenu();
        }

    }
    
    

}
