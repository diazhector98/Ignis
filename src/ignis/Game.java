/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

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
    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());
        Assets.init();
        //Initialize player
        player = new Player(getWidth() / 2, getHeight() - 100, 1, 100, 100, this);
        
        //Initialize doors
        
        int doorWidth = 75;
        int doorHeight = 150;
        int delta = 200;
        int verticalMargin = 100;
        int horizontalMargin = 250;
        for(int i = 0; i < 3; i++){
            doors.add(new Door(10,i * delta + verticalMargin, doorWidth, doorHeight, this));
            doors.add(new Door(i * delta + horizontalMargin, 20, doorHeight, doorWidth, this));
            doors.add(new Door(getWidth() - 100,i * delta + verticalMargin, doorWidth, doorHeight, this));
            System.out.println("3 doors added");
        }
        
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

    private void tick() {
        keyManager.tick();
        // avancing player with colision
        player.tick();
        doorsTick();
    }
    
    public void doorsTick(){
        for(int i = 0; i < doors.size(); i++){
            Door d = doors.get(i);
            d.tick();
        }
    }
    
    private void restartGame(){
       
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
            renderWorldMenu();
            player.render(g);
            doorsRender();
            bs.show();
            g.dispose();
        }
    }
    
    public void doorsRender(){
        for(int i = 0; i < doors.size(); i++){
            Door d = doors.get(i);
            d.render(g);
        }
    }
    
    private void renderWorldMenu(){
        g.drawImage(Assets.background, 0, 0, width, height, null);
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
