/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

/**
 *
 * @author rober
 */
public class Tree extends Enemy{
    
    /**
     *
     * @param p Object Plataform to indicate in which platform Enemy Tree is going to respawn 
     */
    public Tree(Platform p) {
        super(3, 5, p, 2);
    }
    
}