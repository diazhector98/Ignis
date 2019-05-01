/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author hectordiazaceves
 */
public class Atom extends PhysicsObject{
    
    private int width;
    private int height;
    private String element;
    private Platform platform;
    private boolean airborne;
    private int jumpingForce;
    
    public Atom(Game g, Platform p,String e) {
        super(p.getX(), p.getY() - 60, g.getHeight());
        this.width = 50;
        this.height = 50;
        this.platform = p;
        this.jumpingForce = 15;
        this.element = e;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    public boolean intersectsPlatform() {
        return getPerimetro().intersects((platform.getPerimetro())); 
    }
    
    
    
    @Override
    public void tick() {
        update();
        if(intersectsPlatform()){
            jump();
        }
    }

    public void jump() {
        setY(getY() - 5);
        accelerate(0, -1 * jumpingForce);
    }

    @Override
    public void render(Graphics g) {
        if(element.equals("H")){
            g.drawImage(Assets.hydrogenAtom, getX(), getY(), getWidth(), getHeight(), null);
        } else if (element.equals("O")){
            g.drawImage(Assets.oxygenAtom, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
    
    
    
}