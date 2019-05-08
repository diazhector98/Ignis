/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author antoniomejorado
 */
public class MouseManager  implements MouseListener, MouseMotionListener {
    private boolean izquierdo;          // to check if left has been pushed
    private boolean derecho;            // to check if right has been pushed
    private int x;                      // to get x position of the mouse
    private int y;                      // to get y position of the mouse
    
    /**
     *
     */
    public MouseManager() {
        izquierdo = false;
        derecho = false;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return
     */
    public boolean isIzquierdo() {
        return izquierdo;
    }

    /**
     *
     * @return
     */
    public boolean isDerecho() {
        return derecho;
    }

    /**
     *
     * @param izquierdo
     */
    public void setIzquierdo(boolean izquierdo) {
        this.izquierdo = izquierdo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        izquierdo = true;
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        izquierdo = false;

    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
