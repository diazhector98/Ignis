package ignis;

import ignis.Assets.Assets;
import ignis.Assets.PlayerAssets;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;

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
    private boolean facingLeft;
    private boolean facingRight;
    private boolean facingFront;
    private boolean facingBack;
    private boolean right=false, left=false, up=false, down=false;
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
        Platform p = (Platform) obj;
        if (isOnTopOfPlatform(obj)) {
            p.setIntersected(true);
            setJumping(false);
            setSpeedY(0);
            //setY(((Platform) obj).getY() - getHeight());
            setOnFloor(true);
        } else {
            p.setIntersected(false);
        }
    }
    
    public boolean isOnTopOfPlatform(Object obj) {
        boolean correctX = false;
        Platform p = (Platform) obj;
        
        if(getPerimetro().intersects(p.getPerimetroUp())){
            setSpeedY(0);
            up=false;
            jumping=false;
            System.out.println("Up");
        }
        
        if(getPerimetro().intersects(p.getPerimetroLeft())){
            setX(getX()-10);
            left=true;
            System.out.println("left");
        }
        
        if(getPerimetro().intersects(p.getPerimetroRight())){
            setX(getX()+10);
            right=true;
            System.out.println("right");
        }
        
        if(getPerimetro().intersects(p.getPerimetroDown())){
            setSpeedY(5);
            right=true;
            System.out.println("right");
        }
        
      
        return correctX;// && correctY;
    }
    
    public boolean intersectsFire(Object obj){
        return obj instanceof Fire && getPerimetro().intersects(((Fire) obj).getPerimetro());
                
    }
    
    public boolean intersectsEnemy(Object obj){
        return obj instanceof Enemy && getPerimetro().intersects(((Enemy) obj).getPerimetro());
    }

    public boolean isOnFloor() {
        return onFloor;
    }

    public void setOnFloor(boolean onFloor) {
        this.onFloor = onFloor;
    }

    public boolean isOnPlatformRight() {
        return right;
    }

    public void setOnPlatformRight(boolean onPlatformRight) {
        this.right = onPlatformRight;
    }

    public boolean isOnPlatformLeft() {
        return left;
    }

    public void setOnPlatformLeft(boolean onPlatformLeft) {
        this.left = onPlatformLeft;
    }
    
    public boolean intersectsBuildingFromLeft(Building building){
        if(getPerimetro().intersects(building.getPerimeter())){
            if(getX() + getWidth() <= building.getX() + 10){
                return true;
            }
        }
        return false;
    }
    
    public boolean intersectsBuildingFromRight(Building building){
        if(getPerimetro().intersects(building.getPerimeter())){
            if(getX() >= building.getX() + building.getWidth()-10){
                return true;
            }
        }
        return false;
    }
    
    public boolean intersectsBuildingFromTop(Building building){
        if(getPerimetro().intersects(building.getPerimeter())){
            if(getY() + getHeight() >= building.getY() && getY() < building.getY()){
                if(getX() + getWidth() < building.getX()+building.getWidth()){
                    if(getX() > building.getX()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
 
    public boolean intersectsBuildingFromBottom(Building building) {
        if (getPerimetro().intersects(building.getPerimeter())) {
            if (getY()  > building.getY() + building.getHeight()-30) {
                if (getX() + getWidth() < building.getX() + building.getWidth()) {
                    if (getX() > building.getX()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    
    public boolean handleBuildingIntersection(Building building) {
        if (intersectsBuildingFromLeft(building)) {
            setX(getX()-10);
            return true;
        } else if (intersectsBuildingFromRight(building)) {
            setX(getX()+10);
            return true;
        } else if (intersectsBuildingFromTop(building)) {
            setY(getY()-10);
            return true;

        } else if (intersectsBuildingFromBottom(building)) {
            setY(getY()+10);
            return true;
        }
        
        return false;
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
    
    public void addAtom(String element){
        if(atoms.containsKey(element)){
            int qty = atoms.get(element);
            atoms.put(element, qty + 1);
        } else {
            atoms.put(element, 1);
        }
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
            
            if (game.getKeyManager().left && !right) {
                turnLeft();
                moveLeft();
            }
            if (game.getKeyManager().right && !left) {
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
        right=false;
        left=false;
    }
    
    public void printCollectedAtoms(){
        
        Set<String> keys = atoms.keySet();
        Object[] keysArray = keys.toArray();
        
        for(Object k : keysArray){
            int qty = atoms.get(k);
            System.out.println((String)k + " : " + String.valueOf(qty));
        }
        
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
    
    public boolean canBuy(StoreObject so){
        
        Map<String,Integer> playerAtoms = atoms;
        ArrayList<Pair> objectAtoms = so.getCompound().getAtoms();
        
        for(Pair p : objectAtoms){
            String element = (String) p.getKey();
            int qtyNeeded = (Integer) p.getValue();
            if(!playerAtoms.containsKey(element)){
                return false;
            }
            if(playerAtoms.get(element) < qtyNeeded){
                return false;
            }
        }
        
        return true;
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
