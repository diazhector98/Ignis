/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author hectordiazaceves
 */
public class Compound {
    
    private String name;
    private ArrayList<Pair> atoms;
    
    public Compound(String s, String name){
        
        atoms = new ArrayList<>();
        this.name = name;
    }
    
    public void addAtomsFromString(String s){
        int n = s.length();
        int i = 0;
        String element = "";
        String number = "";
        int qty = 0;
        
        while(i < n){
            
        }
        
    }
        
    
}
