/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Worlds;

import ignis.Assets.Assets;
import ignis.Assets.SoundAssets;
import ignis.Assets.TextAssets;
import ignis.Atom;
import ignis.Enemy;
import ignis.Fire;
import ignis.Game;
import ignis.PauseMenu;
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
    protected Graphics g;
    protected int idWorld;
    protected LinkedList<Platform> platforms;
    protected String compuestoBuscar;
    protected LinkedList<Atom> atoms;
    protected int needAtoms = 3;
    protected LinkedList<Enemy> enemies;
    protected PauseMenu pauseMenu;
    protected Boolean paused;
    
    
    public World(Game g, Player p, int id) {
        this.idWorld = id;
        this.g = g.getG();
        this.game = g;
        this.player = p;
        this.platforms = new LinkedList<Platform>();
        this.atoms = new LinkedList<>();
        this.enemies = new LinkedList<>();
        this.pauseMenu = new PauseMenu(g, p, this);
        this.paused = false;
        p.setX(0);
        p.setY(0);
        SoundAssets.init();
    }

    
    public void showPauseMenu(){
        this.pauseMenu.render(this.game.getG());
    }
    
    public void setIdWorld(int id){
        this.idWorld = id;
        
    }
    
    public void setCompuestoBuscar(String compuesto){
        this.compuestoBuscar = compuesto;
    }
    
    public void unPause(){
        this.paused = false;
    }
    
    public void pause() {
        this.paused = true;    
    }
    
    public void returnToMenu() {
        game.setInitialState();
    }
    
    public abstract void tick();
    public abstract void generateWorld();
    public abstract void render(Graphics g);
    
    public void gameOver(Graphics g)
    {
          g.drawImage(Assets.gameOver, 0, 0, game.getWidth(), game.getHeight(), null);
    }

    public void tickPlayer() {
        player.tick();
        for (int i = 0; i < platforms.size(); i++) {
            player.handlePlatformIntersection(platforms.get(i));
        }
    }
    
    public void tickAtoms() {
        ArrayList<Atom> atomsToRemove = new ArrayList<>();
        for (Atom a : atoms) {
            a.tick();
            if (player.intersectsAtom(a)) {
                atomsToRemove.add(a);
                player.addAtom(a.getElement());
                 SoundAssets.atom.play(); 
            }
        }
        for (Atom a : atomsToRemove) {
            atoms.remove(a);
        }
        atomsToRemove.clear();
    }

    public void tickEnemies() {
        for (Enemy e : enemies) {
            e.tick();
            if (player.intersectsEnemy(e) && !player.isInvincible()) {
                player.setInvincibilityTimer(150);
                SoundAssets.hit.play();
                player.loseALife();
            }
        }
    }
    
    public void tickPlatforms() {
        for (Platform p : platforms) {
            p.tick();
        }
    }

    public void renderPlayer(Graphics graphics){
        player.render(graphics);
    }
    
    public void renderAtoms(Graphics graphics) {
        for (Atom a : atoms) {
            a.render(graphics);
        }
    }
    
    public void renderPlatforms(Graphics graphics) {
        for (int i = 0; i < platforms.size(); i++) {
            platforms.get(i).render(graphics);
        }
    }
    
    public void renderEnemies(Graphics graphics) {
        for (Enemy e : enemies) {
            e.render(graphics);
        }
    }

    public void renderPlayerLives(Graphics graphics) {
        for (int i = 0; i < player.getLives(); i++) {
            graphics.drawImage(Assets.heart, (player.getX()) - 580 + i * 30, (player.getY()) - 350 - 45, 20, 20, null);
        }
    }


    
    
    
}
