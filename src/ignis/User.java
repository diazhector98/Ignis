/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.util.Map;

/**
 *
 * @author hectordiazaceves
 */
public class User {
    
    int ID;
    String USERNAME;
    Database database;
    
    /**
     *
     * @param ID Int indicate id username
     * @param username String indicates name of username
     */
    public User(int ID, String username){
     this.ID = ID;
     this.USERNAME = username;
     this.database = new Database();
    }
    
    /**
     *
     * @param symbol String to state the symbol of the element/atom 
     */
    public void addAtom(String symbol){
        
    }
    
    /**
     *
     * @return Database method getUserAtomsMap
     */
    public Map<String, Integer> getAtomQuantities(){
        return database.getUserAtomsMap(ID);
    }
    
    /**
     *Method from database deleteAllUserAtoms
     */
    public void clearAllAtomsFromDatabase() {
        database.deleteAllUserAtoms(ID);
    }
    
    /**
     *
     * @param userAtoms Map<String,Integer> to create user Atoms 
     */
    public void updateAtomQuantities(Map<String,Integer> userAtoms){
        clearAllAtomsFromDatabase();
        Object[] atomSymbols = userAtoms.keySet().toArray();
        for(Object obj : atomSymbols){
            String symbol = (String) obj;
            int quantity = userAtoms.get(symbol);
            database.insertUserAtomQuantity(ID, symbol, quantity);
        }
    }
    
    /**
     *
     * @param so Object from StoreObject to add object 
     */
    public void addObject(StoreObject so){
        database.addObjectToUser(so, ID);
    }
    
    /**
     *
     * @param so Object StoreObject to verify is user has object
     * @return
     */
    public boolean hasObject(StoreObject so){
        return database.userHasObject(ID, so);
    }
    
    /**
     *
     * @return database getUserLives method 
     */
    public int getUserLives(){
        return database.getUserLives(ID);
    }
    
    /**
     *
     * @param newLives Int to state user new lives
     */
    public void updateUserLives(int newLives){
        database.updateUserLives(ID, newLives);
    }
    
    
    
    
    
}
