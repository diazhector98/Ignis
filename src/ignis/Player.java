package ignis;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author antoniomejorado
 */
public class Player extends PhysicsObject {

    private int direction;
    private int width;
    private int height;
    private int speed;
    private Game game;
    private boolean jumping;
    private int jumpingForce;

    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y, game.getHeight());
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 10;
        this.jumping = false;
        this.jumpingForce = 15;
    }

   /**
     * setSpeed
     * Metodo modificador para ajustar la velocidad del jugador
     * @param speed  es la velocidad del objeto
     */
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     *getSpeed
     * Método de acceso que regresa la velocidad del jugador 
     * @return speed es la posición del jugador
     */
    public int getSpeed() {
        return speed;
    }

    /**
     *setWidth
     * Método modificador para ajustar el ancho del jugador
     * @param width es el ancho en pixeles del jugador
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * getWidth
     * Método de acceso que regresa el ancho del jugador
     * @return width es el ancho del jugador
     */
    public int getWidth() {
        return width;
    }

    /**
     * setHeight
     * Método modificador para ajustar la altura del jugador
     * @param height es la altura del jugador en pixeles
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * getHeight
     * Método de acceso que regresa la altura del jugador
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * setDirection
     * Método modificador que ajusta la dirección (1 - Arriba 2 - Derecha 3 - Abajo 4 - Izquierda)
     * @param direction es la dirección a la que se dirige el jugador
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * getDirection
     * Método de acceso que regresa la dirección (1 - Arriba 2 - Derecha 3 - Abajo 4 - Izquierda) a la que se dirige el jugador
     * @return direction es la dirección a la que se dirige el jugador
     */
    public int getDirection() {
        return direction;
    }
    
     /**
     * getPerimetro
     * Método de acceso que regresa el objeto de la clase Rectangle del jugador 
     * que contiene su posición y sus bordes en la pantalla
     * @return r es el objeto de la clase Rectangle del jugador
     */

    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
    
    

    public boolean intersectsDoor(Object obj) {

        Rectangle perimetro = getPerimetro();
        return obj instanceof Door && getPerimetro().intersects(((Door) obj).getPerimetro());     
    }
    
    public boolean intersectsPlatform(Object obj) {

        Rectangle perimetro = getPerimetro();
        return obj instanceof Platform && getPerimetro().intersects(((Platform) obj).getPerimetro());     
    }
    
    
    public void handlePlatformIntersection() {
        setJumping(false);
        setSpeedY(0);
    }

    @Override
    public void tick() {
        // moving player depending on flags
        
        update();
        
        if (game.getKeyManager().up) {
            jump();
        }
        if (game.getKeyManager().down) {
            setY(getY() + getSpeed());
        }
        if (game.getKeyManager().left) {
            moveLeft();
        }
        if (game.getKeyManager().right) {
            moveRight();
        }
        
        // reset x position and y position if colision
        /*
        if (getX() + 60 >= game.getWidth()) {
            setX(game.getWidth() - 60);
        } else if (getX() <= -30) {
            setX(-30);
        }
        */
        /*
        if (getY() + 80 >= game.getHeight()) {
            setY(game.getHeight() - 100);
        } else if (getY() <= -20) {
            setY(-20);
        }
*/
    }
    
    public void moveRight(){
        move(speed, 0);
    }
    
    public void moveLeft(){
        move(-1 * speed, 0);
    }
    
    public void jump(){
        if(!isJumping()){
            setJumping(true);
            setY(getY() - 5);
            accelerate(0, -1 * jumpingForce);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.blueSquare, getX(), getY(), getWidth(), getHeight(), null);
    }
}
