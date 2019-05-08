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
    
    public User(int ID, String username){
     this.ID = ID;
     this.USERNAME = username;
     this.database = new Database();
    }
    
    public void addAtom(String symbol){
        
    }
    
    public Map<String, Integer> getAtomQuantities(){
        return database.getUserAtomsMap(ID);
    }
    
    
    
}
