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
     * @param ID
     * @param username
     */
    public User(int ID, String username){
     this.ID = ID;
     this.USERNAME = username;
     this.database = new Database();
    }
    
    /**
     *
     * @param symbol
     */
    public void addAtom(String symbol){
        
    }
    
    /**
     *
     * @return
     */
    public Map<String, Integer> getAtomQuantities(){
        return database.getUserAtomsMap(ID);
    }
    
    /**
     *
     */
    public void clearAllAtomsFromDatabase() {
        database.deleteAllUserAtoms(ID);
    }
    
    /**
     *
     * @param userAtoms
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
     * @param so
     */
    public void addObject(StoreObject so){
        database.addObjectToUser(so, ID);
    }
    
    /**
     *
     * @param so
     * @return
     */
    public boolean hasObject(StoreObject so){
        return database.userHasObject(ID, so);
    }
    
    /**
     *
     * @return
     */
    public int getUserLives(){
        return database.getUserLives(ID);
    }
    
    /**
     *
     * @param newLives
     */
    public void updateUserLives(int newLives){
        database.updateUserLives(ID, newLives);
    }
    
    
    
    
    
}
