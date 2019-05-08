/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

/**
 *
 * @author hectordiazaceves
 */
public class Robot extends Enemy{
    
    /**
     * Robot (child of enemy class)
     * @param p object platform where it instances.
     */
    public Robot(Platform p) {
        super(3, 5, p, 0);
    }
    
}
