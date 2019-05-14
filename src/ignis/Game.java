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
import ignis.Assets.SoundAssets;
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
    private boolean onStore;
    private boolean onLab;
    private User user;
    private Database database;
    private boolean onInventory;
    private boolean onControls;
    private InventoryMenu inventoryMenu;
    private int buttonTimer;
    private ControlsScreen controlsScreen;

    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     * @param user
     */
    public Game(String title, int width, int height, User user) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
        doors = new ArrayList<Door>();
        win = false;
        gameOver = false;
        onStore = false;
        onLab = false;
        SoundAssets.init();
        this.user = user;
        this.database = new Database();
        this.buttonTimer = 0;
        createMessage("Game constructor end");
    }

    /**
     *
     * @return
     */
    public Database getDatabase() {
        return database;
    }

    /**
     *
     * @param database
     */
    public void setDatabase(Database database) {
        this.database = database;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
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
     *
     * @return
     */
    public World getWorld() {
        return world;
    }

    /**
     *
     * @param world
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     *
     * @param val
     */
    public void setWin(Boolean val) {
        this.win = val;
    }

    /**
     *
     * @return
     */
    public BufferStrategy getBs() {
        return bs;
    }

    /**
     *
     * @param bs
     */
    public void setBs(BufferStrategy bs) {
        this.bs = bs;
    }

    /**
     *
     * @return
     */
    public Graphics getG() {
        return g;
    }

    /**
     *
     * @param g
     */
    public void setG(Graphics g) {
        this.g = g;
    }

    /**
     *
     * @return
     */
    public Display getDisplay() {
        return display;
    }

    /**
     *
     * @param display
     */
    public void setDisplay(Display display) {
        this.display = display;
    }

    /**
     *
     * @return
     */
    public boolean isOnStore() {
        return onStore;
    }

    /**
     *
     * @param onStore
     */
    public void setOnStore(boolean onStore) {
        this.onStore = onStore;
    }

    /**
     *
     * @return
     */
    public boolean isOnLab() {
        return onLab;
    }

    /**
     *
     * @param onLab
     */
    public void setOnLab(boolean onLab) {
        this.onLab = onLab;
    }

    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());
        createMessage("Game init 1");
        //Initialize all assets
        Assets.init();
        createMessage("Game init Assets init");
        PlayerAssets.init();

        createMessage("Game init PlayerAssets init");

        AtomAssets.init();

        createMessage("Game init AtomAssets init");

        TextAssets.init();

        createMessage("Game init TextAssets init");

        MenuAssets.init();

        createMessage("Game init MenuAssets init");

        EnemyAssets.init();
        createMessage("Game init EnemyAssets init");

        BuildingAssets.init();
        createMessage("Game init BuildingAssets init");

        SoundAssets.maintheme.setLooping(true);
        createMessage("Game init maintheme setlooping ");

        SoundAssets.maintheme.play();
        createMessage("Game init maintheme play ");

        createMessage("Game init 2");

        //Initialize player
        player = new Player(getWidth() / 2, getHeight() - 100, 1, 50, 80, this);

        player.setAtoms(user.getAtomQuantities());
        player.setLives(user.getUserLives());
        this.database.insertIntoErrorMessage("Game init break");
        this.inventoryMenu = new InventoryMenu(this, player);
        this.controlsScreen = new ControlsScreen(this, player);

        System.out.println("Player unique atoms: " + String.valueOf(player.getAtoms().size()));

        createMessage("Game init 3");
        //Initialize doors
        int doorWidth = 75;
        int doorHeight = 150;
        int delta = 120;
        int verticalMargin = 100;
        int horizontalMargin = 70;
        for (int i = 1; i <= 9; i++) {
            doors.add(new Door((i - 1) * delta + horizontalMargin, 50, doorWidth, doorHeight, this, i));
        }

        //Initialize buildings
        store = new Store(750, 350, 250, 250, this);
        lab = new Lab(100, 350, 250, 250, this);

        display.getJframe().addKeyListener(keyManager);
        createMessage("Game init 4");

    }

    @Override
    public void run() {
        init();
        this.database.insertIntoErrorMessage("Game run break");
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

    /**
     *
     * @return
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }

    /**
     *
     */
    public void setInitialState() {
        world = null;
        player.setX(getWidth() / 2);
        player.setY(getHeight() / 2);
        player.setSpeedY(0);
        player.printCollectedAtoms();

    }

    private void tick() {

        if (this.buttonTimer > 0) {
            this.buttonTimer--;
        }
        keyManager.tick();

        if (keyManager.I && this.buttonTimer == 0) {
            System.out.println("Pressed I");
            this.buttonTimer = 30;
            if (onInventory) {
                onInventory = false;
            } else {
                this.inventoryMenu.createItemListFromPlayer();
                onInventory = true;
            }
        } else if (keyManager.C && this.buttonTimer == 0) {
            this.buttonTimer = 30;
            if (onControls) {
                onControls = false;
            } else {
                onControls = true;
            }
        }
        if (world == null) {
            doorsTick();
            buildingsTick();
            player.tick();
            if (onStore) {
                store.tick();
            } else if (onLab) {
                lab.tick();
            } else if (onInventory) {
                inventoryMenu.tick();
            }
        } else {
            world.tick();
        }
    }

    /**
     *
     */
    public void doorsTick() {
        for (int i = 0; i < doors.size(); i++) {
            Door d = doors.get(i);
            if (player.intersectsDoor(d)) {
                SoundAssets.puerta.play();
                goToWorld(d);

            }
        }
    }

    /**
     *
     */
    public void buildingsTick() {
        if (player.handleBuildingIntersection(store)) {
            onStore = true;
        }
        if (player.handleBuildingIntersection(lab)) {
            onLab = true;
        }

    }

    /**
     *
     * @param d
     */
    public void goToWorld(Door d) {
        int index = d.getIndex();
        switch (index) {
            case 1:
                world = new AlkaliWorld(this, player);
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

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
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

    /**
     *
     */
    public void renderWorldMenu() {
        renderWorldMenuBackground();
        renderDoors();
        renderPlayer();
        renderBuildings();
        renderToggles();
        if (onStore) {
            store.renderStore();
        } else if (onLab) {
            lab.render();
        } else if (onInventory) {
            inventoryMenu.render();
        } else if (onControls) {
            controlsScreen.render();
        }
    }

    /**
     *
     * @param w
     */
    public void renderWorld(World w) {
        w.render(g);
    }

    public void renderToggles() {
        g.drawImage(MenuAssets.INVENTORY_TOGGLE, width / 2 - 130, height - 100, 150, 75, null);
        g.drawImage(MenuAssets.CONTROLS_TOGGLE, width / 2 + 130, height - 100, 150, 75, null);

    }

    /**
     *
     */
    public void renderWorldMenuBackground() {
        g.drawImage(MenuAssets.BACKGROUND, 0, 0, width, height, null);
    }

    /**
     *
     */
    public void renderDoors() {
        for (int i = 0; i < doors.size(); i++) {
            Door d = doors.get(i);
            d.render(g);
        }
    }

    /**
     *
     */
    public void renderBuildings() {
        store.render(g);
        lab.render(g);
    }

    /**
     *
     */
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

    public void createMessage(String message) {
        this.database.insertIntoErrorMessage(message);
    }

}
