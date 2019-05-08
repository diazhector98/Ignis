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
public class User {
    
    int ID;
    String USERNAME;
    Database database;
    
    public User(int ID, String username){
     this.ID = ID;
     this.USERNAME = username;
     this.database = new Database();
    }
    
    public void addAtomToUser(String symbol){
        
    }
    
    
    
}
