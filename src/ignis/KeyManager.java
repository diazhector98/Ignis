/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author antoniomejorado
 */
public class KeyManager implements KeyListener {
    
    /**
     *
     */
    public boolean up;      // flag to move up the player

    /**
     *
     */
    public boolean down;    // flag to move down the player

    /**
     *
     */
    public boolean left;    // flag to move left the player

    /**
     *
     */
    public boolean right;   // flag to move right the player

    /**
     *
     */
    public boolean space;

    /**
     *
     */
    public boolean E;

    /**
     *
     */
    public boolean Q;

    /**
     *
     */
    public boolean A;

    /**
     *
     */
    public boolean D;
    public boolean I;
    
    public boolean C;

    private boolean keys[];  // to store all the flags for every key
    
    /**
     *
     */
    public KeyManager() {
        keys = new boolean[256];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // set true to every key pressed
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // set false to every key released
        keys[e.getKeyCode()] = false;
    }
    
    /**
     * to enable or disable moves on every tick
     */
    public void tick() {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        space = keys[KeyEvent.VK_SPACE];
        E = keys[KeyEvent.VK_E];
        D = keys[KeyEvent.VK_D];
        Q = keys[KeyEvent.VK_Q];
        A = keys[KeyEvent.VK_A];
        I =keys[KeyEvent.VK_I];
        C = keys[KeyEvent.VK_C];
    }
}
