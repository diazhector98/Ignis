/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.Assets;
import ignis.Assets.AtomAssets;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectordiazaceves
 */
public class Atom extends PhysicsObject {

    private int width;
    private int height;
    private String element;
    private Platform platform;
    private boolean airborne;
    private int jumpingForce;
    private BufferedImage image;

    /**
     *
     * @param g
     * @param p
     * @param e
     */
    public Atom(Game g, Platform p, String e) {
        super(p.getX(), p.getY() - 60, g.getHeight());
        this.width = 50;
        this.height = 50;
        this.platform = p;
        this.jumpingForce = 15;
        this.element = e;
        this.image = AtomAssets.getAtomImage(e);
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    /**
     *
     * @return
     */
    public boolean intersectsPlatform() {
        return getPerimetro().intersects((platform.getPerimetro()));
    }

    /**
     *
     * @return String con el elemento
     */
    public String getElement() {
        return element;
    }

    /**
     *
     * @param element
     */
    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public void tick() {
        update();
        if (intersectsPlatform()) {
            jump();
        }
    }

    /**
     *
     */
    public void jump() {
        setY(getY() - 5);
        accelerate(0, -1 * jumpingForce);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.image, getX(), getY(), getWidth(), getHeight(), null);
    }

}
