/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Worlds;

import ignis.Assets.Assets;
import ignis.Assets.TextAssets;
import ignis.Assets.WorldAssets.LanthanoidWorldAssets;
import ignis.Assets.WorldAssets.NobleGasWorldAssets;
import ignis.Atom;
import ignis.Enemy;
import ignis.Game;
import ignis.Platform;
import ignis.Player;
import ignis.enemy6;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hectordiazaceves
 */
public class LanthanoidWorld extends World {
private Map<String, Integer> atomQuantities;
    public LanthanoidWorld(Game g, Player p) {
        super(g, p, 3);
        LanthanoidWorldAssets.init();
         player.setX(400);
        player.setY(4700);
        atomQuantities = new HashMap<>();
        atomQuantities.put("Lu", 2);
        atomQuantities.put("O", 3);
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

    @Override
    public void tick() {
        if (!paused) {
            tickAtoms();
            tickPlayer();
            tickEnemies();
            tickPlatforms();
            if (game.getKeyManager().space) {
                paused = true;
            }
        } else {
            pauseMenu.tick();
        }

    }

    @Override
    public void generateWorld() {
          LinkedList<Platform> platformsWithAtom = new LinkedList<>();
        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 100; x++) {
                int pixel = LanthanoidWorldAssets.world.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (getColor(red, green, blue).equals("WHITE")) {
                    platforms.add(new Platform(x * 100, y * 100, 100, 100, "STATIC", LanthanoidWorldAssets.block));
                } else if (getColor(red, green, blue).equals("GREEN")) {
                    platforms.add(new Platform(x * 100, y * 100, 100, 100, "ACTIVE", LanthanoidWorldAssets.block));
                }
                else if (getColor(red, green, blue).equals("BLUE")) {
                    Platform p = new Platform(x * 100, y * 100, 100, 100, "ATOM", LanthanoidWorldAssets.block);
                    platforms.add(p);
                    platformsWithAtom.add(p);
                    
                }
                  else if (getColor(red, green, blue).equals("RED")) {
                    Platform p = new Platform(x * 100, y * 100, 100, 100, "Enemy6", LanthanoidWorldAssets.block);
                    platforms.add(p);
                    enemies.add(new enemy6(p));
                }
                
            }
        }
            Set<String> keys = atomQuantities.keySet();
        for(int i=0; i<atomQuantities.size(); i++){
            String elemento = (String)keys.toArray()[i];
            for(int j=0;j<atomQuantities.get(elemento);j++){
                int k = (int) ((Math.random() * ((platformsWithAtom.size()-1 - 0) + 1)) + 0);
                System.out.println(k);
                
                Platform p = platformsWithAtom.get(k);
                Atom a = new Atom(game,p, elemento);
                platformsWithAtom.remove(k);
                atoms.add(a);
                
            }
        }
        
        int elementIndex = 0;
        int n = keys.size();
        for (Platform p : platformsWithAtom){
            String elemento = (String)keys.toArray()[elementIndex % n];
            Atom a = new Atom(game, p, elemento);
            atoms.add(a);
            elementIndex++;
        }
    }

    @Override
    public void render(Graphics g) {
        if (!paused) {
            g.drawImage(Assets.darkGraySquare, 0, 0, game.getWidth(), game.getHeight(), null);
            g.translate(-(player.getX() - 1200 / 2), -(player.getY() - 800 / 2));
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
