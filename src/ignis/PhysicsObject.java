/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

/**
 *
 * @author hectordiazaceves
 * https://stackoverflow.com/a/35478610
 */
public abstract class PhysicsObject extends Item {
    
    /**
     *
     */
    public static final double FRICTION = 1;

    /**
     *
     */
    public static final double GRAVITY = 0.4;
    private double speedX = 0;
    private double speedY = 0;
    private int ground;

    /**
     *
     * @param x
     * @param y
     * @param g
     */
    public PhysicsObject(int x, int y, int g) {
        super(x, y);
        ground = g;
    }

    /**
     *
     * @return
     */
    public double getSpeedX(){
        return speedX;
    }

    /**
     *
     * @param speedX
     */
    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    /**
     *
     * @return
     */
    public double getSpeedY() {
        return speedY;
    }

    /**
     *
     * @param speedY
     */
    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    /**
     *
     * @param accelerationX
     * @param accelerationY
     */
    public void accelerate(double accelerationX, double accelerationY) {
        speedX += accelerationX;
        speedY += accelerationY;
    }

    /**
     *
     * @param xDelta
     * @param yDelta
     */
    public void move(double xDelta, double yDelta){
        setX(getX() + (int)xDelta);
        setY(getY() + (int)yDelta);
        
        // do collision detection here. upon collision, set speedX/speedY to zero..!
    }

    /**
     *
     */
    public void update(){
        move(speedX, speedY);
        speedX *= FRICTION;
        speedY *= FRICTION;
        accelerate(0, GRAVITY); // gravity accelerates the object downwards each tick
    }
    
}
