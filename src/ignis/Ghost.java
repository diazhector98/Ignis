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
public class Ghost extends Enemy{
    
    /**Ghost
     * Builds the ghost enemy
     * @param p
     */
    public Ghost(Platform p) {
        super(3, 5, p, 3);
    }
    
}
