/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Worlds.World;
import ignis.Assets.Assets;
import ignis.Assets.AtomAssets;
import ignis.Assets.BuildingAssets;
import ignis.Assets.EnemyAssets;
import ignis.Assets.PlayerAssets;
import ignis.Assets.TextAssets;

import ignis.Assets.MenuAssets;
import ignis.Worlds.ActinoidWorld;
import ignis.Worlds.AlkaliWorld;
import ignis.Worlds.AlkalineWorld;
import ignis.Worlds.LanthanoidWorld;
import ignis.Worlds.MetalloidWorld;
import ignis.Worlds.NobleGasWorld;
import ignis.Worlds.NonMetalWorld;
import ignis.Worlds.PostTransitionWorld;
import ignis.Worlds.TransitionWorld;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author antoniomejorado
 */
public class Game implements Runnable {

    private BufferStrategy bs;      // to have several buffers when displaying
    private Graphics g;             // to paint objects
    private Display display;        // to display in the game
    String title;                   // title of the window
    private int width;              // width of the window
    private int height;             // height of the window
    private Thread thread;          // thread to create the game
    private boolean running;        // to set the game
    private Player player;          // to use a playe
    private KeyManager keyManager;  // to manage the keyboard
    private ArrayList<Door> doors;
    private World world;
    private Platform platform;
    private Platform platform2;
    private Boolean win;
    private Boolean gameOver;
    private Store store;
    private Lab lab;
    

    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
        doors = new ArrayList<Door>();
        win = false;
        gameOver=false;
        
    }

    /**
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
    public void setWin(Boolean val){
        this.win = val;
    }

    public BufferStrategy getBs() {
        return bs;
    }

    public void setBs(BufferStrategy bs) {
        this.bs = bs;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
    
    
    
    
    

    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());
        //Initialize all assets
        Assets.init();
        PlayerAssets.init();
        AtomAssets.init();
        TextAssets.init();
        MenuAssets.init();
        EnemyAssets.init();
        BuildingAssets.init();
        //Initialize player
        player = new Player(getWidth() / 2, getHeight() - 100, 1, 50, 80, this);

        //Initialize doors
        int doorWidth = 75;
        int doorHeight = 150;
        int delta = 120;
        int verticalMargin = 100;
        int horizontalMargin = 70;
        for (int i = 1; i <= 9; i++) {
            doors.add(new Door((i-1) * delta + horizontalMargin, 50, doorWidth, doorHeight, this, i));
        }
        
        //Initialize buildings
        store = new Store(750,300,350,350, this);
        lab = new Lab(100,300,350,350, this);
        

        display.getJframe().addKeyListener(keyManager);
    }

    @Override
    public void run() {
        init();
        // frames per second
        int fps = 50;
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running) {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            // updating the last time
            lastTime = now;

            // if delta is positive we tick the game
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    
    public void setInitialState() {
        world = null;
        player.setX(getWidth() / 2);
        player.setY(getHeight() / 2);
        player.setSpeedY(0);

    }

    private void tick() {
        keyManager.tick();
        if(world == null){
            doorsTick();
            player.tick();
        } else {
            world.tick();
        }
    }

    public void doorsTick() {
        for (int i = 0; i < doors.size(); i++) {
            Door d = doors.get(i);
            d.tick();
            if (player.intersectsDoor(d)) {
                goToWorld(d);
            }
        }
    }
    
    
    

    public void goToWorld(Door d) {
        int index = d.getIndex();
        switch(index){
            case 1:
                world = new AlkaliWorld(this,player);
                break;
            case 2:
                world = new AlkalineWorld(this, player);
                break;
            case 3:
                world = new LanthanoidWorld(this, player);
                break;
            case 4:
                world = new ActinoidWorld(this, player);
                break;
            case 5:
                world = new TransitionWorld(this, player);
                break;
            case 6:
                world = new PostTransitionWorld(this, player);
                break;
            case 7:
                world = new MetalloidWorld(this, player);
                break;
            case 8:
                world = new NonMetalWorld(this, player);
                break;
            case 9:
                world = new NobleGasWorld(this, player);
                break;
        }
        world.generateWorld();
    }

    private void restartGame() {

    }

    private void render() {
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectanlge, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
         */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            if (world == null) {
                renderWorldMenu();
            } else {
                renderWorld(world);
            }
            bs.show();
            g.dispose();
        }
    }
    
    public void renderWorldMenu(){
        renderWorldMenuBackground();
        renderDoors();
        renderPlayer();
        renderBuildings();
    }

    public void renderWorld(World w) {
        w.render(g);   
    }

    public void renderWorldMenuBackground(){
        g.drawImage(MenuAssets.BACKGROUND, 0, 0, width, height, null); 
    }
    public void renderDoors() {
        for (int i = 0; i < doors.size(); i++) {
            Door d = doors.get(i);
            d.render(g);
        }
    }
    
    public void renderBuildings() {
        store.render(g);
        lab.render(g);
    }
    
    public void renderPlayer() {
        player.render(g);
    }

    /**
     * setting the thead for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * stopping the thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

}
