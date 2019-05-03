package ignis;

import ignis.Assets.Assets;
import ignis.Assets.PlayerAssets;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
    private boolean onFloor;
    private boolean onPlatformRight;
    private boolean onPlatformLeft;
    private boolean facingLeft;
    private boolean facingRight;
    private boolean facingFront;
    private boolean facingBack;
    private int lives;
    
    private Animation leftAnimation;
    private Animation rightAnimation;
    private Animation frontAnimation;
    private Animation backAnimation;
    
    private int invincibilityTimer;
    
    private Map<String, Integer> atoms;


    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y, game.getHeight());
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 5;
        this.jumping = false;
        this.jumpingForce = 15;
        this.onFloor = true;
        this.facingRight = true;
        this.facingLeft = false;
        this.facingFront = false;
        this.facingBack = false;
        this.lives = 5;
        this.leftAnimation = new Animation(PlayerAssets.playerLeftImages, 100);
        this.rightAnimation = new Animation(PlayerAssets.playerRightImages, 100);
        this.frontAnimation = new Animation(PlayerAssets.playerFrontImages, 100);
        this.backAnimation = new Animation(PlayerAssets.playerBackImages, 100);
        this.invincibilityTimer = 0;
        atoms = new HashMap<String, Integer>();


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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
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
    
    public boolean intersectsAtom(Object obj){
        return obj instanceof Atom && getPerimetro().intersects(((Atom) obj).getPerimetro());
    }
    
    public boolean intersectsPlatform(Object obj) {

        Rectangle perimetro = getPerimetro();
        return obj instanceof Platform && getPerimetro().intersects(((Platform) obj).getPerimetro());     
    }
    
    public void handlePlatformIntersection(Object obj) {
        if (intersectsPlatformFromAbove(obj)) {
            setJumping(false);
            setSpeedY(0);
            setY(((Platform) obj).getY() - getHeight());
            setOnFloor(true);
        }
    }
    
    public boolean intersectsAnyPlatformFromTheLeft(LinkedList<Platform> map){
        for(Platform p : map){
            if(intersectsPlatformFromLeft(p)){
                return true;
            }
        }
        return false;
    }
    
    public boolean intersectsAnyPlatformFromTheRight(LinkedList<Platform> map){
        for(Platform p : map){
            if(intersectsPlatformFromRight(p)){
                return true;
            }
        }
        return false;
    }
    
    public boolean intersectsPlatformFromAbove(Object obj){
        return obj instanceof Platform
                && getPerimetro().intersects(((Platform) obj).getPerimetro())
                && getY() + 6 * getHeight() / 10 <= ((Platform) obj).getY();   
    }
    
    
    public boolean intersectsPlatformFromRight(Object obj){
        return obj instanceof Platform
            && getPerimetro().intersects(((Platform) obj).getPerimetro())
            && (getX() + 1 > ((Platform) obj).getX()) && !intersectsPlatformFromAbove(obj); 
    }
    
    public boolean intersectsPlatformFromLeft(Object obj){
        return obj instanceof Platform
            && getPerimetro().intersects(((Platform) obj).getPerimetro())
            && (getX() + 1 < ((Platform) obj).getX()) && !intersectsPlatformFromAbove(obj); 
    }
    
    public boolean intersectsFire(Object obj){
        return obj instanceof Fire && getPerimetro().intersects(((Fire) obj).getPerimetro());
                
    }
    
    public boolean intersectsEnemy(Object obj){
        return obj instanceof Enemy && getPerimetro().intersects(((Enemy) obj).getPerimetro());
    }
    
    
    public void handleTopPlatformIntersection() {
        System.out.println("Handle top intersection");
        setJumping(false);
        setSpeedY(0);
        setOnFloor(true);
    }

    public boolean isOnFloor() {
        return onFloor;
    }

    public void setOnFloor(boolean onFloor) {
        this.onFloor = onFloor;
    }
    
    public void handleRightPlatformIntersection() {
        setOnPlatformRight(true);
    }
    
    public void handleLeftPlatformIntersection() {
        setOnPlatformLeft(true);
    }

    public boolean isOnPlatformRight() {
        return onPlatformRight;
    }

    public void setOnPlatformRight(boolean onPlatformRight) {
        this.onPlatformRight = onPlatformRight;
    }

    public boolean isOnPlatformLeft() {
        return onPlatformLeft;
    }

    public void setOnPlatformLeft(boolean onPlatformLeft) {
        this.onPlatformLeft = onPlatformLeft;
    }
    
    public void turnBack(){
        this.facingBack = true;
        this.facingFront = false;
        this.facingLeft = false;
        this.facingRight = false;
    }
    
    public void turnFront(){
        this.facingBack = false;
        this.facingFront = true;
        this.facingLeft = false;
        this.facingRight = false;
    }
    
    public void turnRight(){
        this.facingBack = false;
        this.facingFront = false;
        this.facingLeft = false;
        this.facingRight = true;
    }
    
    public void turnLeft(){
        this.facingBack = false;
        this.facingFront = false;
        this.facingLeft = true;
        this.facingRight = false;
    }
    
    public void loseALife(){
        this.lives -= 1;
    }
    
    public boolean isInvincible(){
        return invincibilityTimer > 0;
    }
    
    public void setInvincibilityTimer(int n){
        this.invincibilityTimer = n;
    }
    
    public int getInvincibilityTimer(){
        return this.invincibilityTimer;
    }

    @Override
    public void tick() {
        // moving player depending on flags
        
        this.leftAnimation.tick();
        this.rightAnimation.tick();
        this.frontAnimation.tick();
        this.backAnimation.tick();
        
        if(getInvincibilityTimer() > 0){
            setInvincibilityTimer(getInvincibilityTimer() - 1);
        }
        
        
        if (this.game.getWorld() != null) {
            update();
            if (game.getKeyManager().up) {
                jump();
            }
            if (game.getKeyManager().down && !isOnFloor()) {
                setY(getY() + getSpeed());
            }
            if (game.getKeyManager().left && !isOnPlatformRight()) {
                turnLeft();
                moveLeft();
            }
            if (game.getKeyManager().right && !isOnPlatformLeft()) {
                moveRight();
                turnRight();
            }
        } else {
            if (game.getKeyManager().up) {
                setY(getY() - getSpeed());
                turnBack();
                
            }
            if (game.getKeyManager().down) {
                setY(getY() + getSpeed());
                turnFront();
            }
            if (game.getKeyManager().left) {
                setX(getX() - getSpeed());
                turnLeft();
            }
            if (game.getKeyManager().right) {
                setX(getX() + getSpeed());
                turnRight();
            }
        
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
        if(facingRight){
            g.drawImage(rightAnimation.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (facingLeft){
            g.drawImage(leftAnimation.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (facingFront){
            g.drawImage(frontAnimation.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (facingBack){
            g.drawImage(backAnimation.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }

    }
}
