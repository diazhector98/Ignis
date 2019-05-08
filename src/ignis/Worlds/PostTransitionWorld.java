/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Worlds;

import ignis.Assets.Assets;
import ignis.Assets.TextAssets;
import ignis.Assets.WorldAssets.AlkaliWorldAssets;
import ignis.Assets.WorldAssets.NobleGasWorldAssets;
import ignis.Assets.WorldAssets.PostTransitionWorldAssets;

import ignis.Assets.WorldAssets.PostTransitionWorldAssets;
import ignis.Atom;
import ignis.Enemy;
import ignis.Robot;
import ignis.Game;
import ignis.Platform;
import ignis.Player;
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
public class PostTransitionWorld extends World {
    private Map<String, Integer> atomQuantities;

    public PostTransitionWorld(Game g, Player p) {
        super(g, p, 6);
        PostTransitionWorldAssets.init();
        player.setY(4500);
        player.setX(500);
        atomQuantities = new HashMap<>();
        //Poner cantidades minimas de los atomos que se necesitan
        atomQuantities.put("Al", 2);
        atomQuantities.put("Ga", 2);
        atomQuantities.put("Sn", 2);
        atomQuantities.put("Bi", 1);
    }

        public String getColor(int red, int green, int blue){
        if(red == 255 && green == 255 && blue == 255){
            return "WHITE";
        } else if(red == 0 && green == 0 && blue == 0){
            return "BLACK";
        } else if(red > green && red > blue){
            return "RED";
        } else if(red == 0 && green == 255 && blue == 0){
            return "GREEN";
        } else if( red == 00 && green == 0 && blue == 255){
            return "BLUE";
        } else if(red == 255 && green == 0 && blue == 255){
            return "RED";
        } else {
            return "NOT DETECTED";
        }
    }
        
    @Override
    public void tick() {
        System.out.println(atoms.size());
        if(!paused){
            tickAtoms();
            tickPlayer();
            tickEnemies();
            tickPlatforms();
            if(game.getKeyManager().space){
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
                int pixel = PostTransitionWorldAssets.world.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (getColor(red, green, blue).equals("WHITE")) {
                    platforms.add(new Platform(x * 100, y * 100, 100, 100, "STATIC", PostTransitionWorldAssets.block));
                } else if (getColor(red, green, blue).equals("GREEN")) {
                    platforms.add(new Platform(x * 100, y * 100, 100, 100, "ACTIVE", PostTransitionWorldAssets.block));
                }
                else if (getColor(red, green, blue).equals("BLUE")) {
                    Platform p = new Platform(x * 100, y * 100, 100, 100, "ATOM", PostTransitionWorldAssets.block);
                    platforms.add(p);
                    platformsWithAtom.add(p);
                    
                } else if (getColor(red, green, blue).equals("RED")) {
                    Platform p = new Platform(x * 100, y * 100, 100, 100, "Robot", PostTransitionWorldAssets.block);
                    platforms.add(p);
                    enemies.add(new Robot(p));
                }
                
            }
        }
        
        Set<String> keys = atomQuantities.keySet();
        for(int i=0; i<atomQuantities.size(); i++){
            String elemento = (String)keys.toArray()[i];
            for(int j=0;j<atomQuantities.get(elemento);j++){
                int k = (int) ((Math.random() * ((platformsWithAtom.size()-1 - 0) + 1)) + 0);
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
            g.drawImage(PostTransitionWorldAssets.background, 0, 0, game.getWidth(), game.getHeight(), null);
            g.translate(-(player.getX() - 1200 / 2), -(player.getY() - 800 / 2));
            renderAtoms(g);
            renderPlatforms(g);
            renderEnemies(g);
            renderPlayer(g);
            renderPlayerLives(g);
        } else {
            showPauseMenu();
        }
    }

}
