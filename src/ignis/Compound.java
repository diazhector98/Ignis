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
        addAtomsFromString(s);
        this.name = name;
    }

    public void addAtomsFromString(String s) {
        int n = s.length();
        int i = 0;
        String element = "";
        String number = "";
        int qty = 0;

        boolean symbol = true;
        element += s.charAt(i);
        i++;
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (symbol) {
                    symbol = false;
                }
                number += c;
            } else {
                if (Character.isLowerCase(c)) {
                    element += c;
                } else {
                    addAtomToCompound(element, number.equals("") ? 1 : Integer.parseInt(number));
                    element = "" + c;
                    number = "";
                }
            }
            i++;
        }
        addAtomToCompound(element, number.equals("") ? 1 : Integer.parseInt(number));

    }
    
    public void addAtomToCompound(String s, int qty){
        atoms.add(new Pair(s, qty));
    }
    
    public void printCompound(){
        for(Pair p : atoms){
            String element = (String)p.getKey();
            int qty = (Integer) p.getValue();
            System.out.println(element + String.valueOf(qty));
        }
    }
        
    
}
