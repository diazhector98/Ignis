/*i+=0.1;
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

/**
 *
 * @author hectordiazaceves
 */
public class Cloud extends Enemy{
    int step=0;

    /**
     *
     * @param p
     */
    public Cloud(Platform p) {
        super(3, 5, p, 1);
        
    }
    
    
}
