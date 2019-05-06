/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.BuildingAssets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author hectordiazaceves
 */
public class Store extends Building{
    
    private Button backButton;
    private ArrayList<StoreObject> items;
    private Graphics graphics;
    
    public Store(int x, int y, int width, int height, Game g) {
        super(x, y, width, height, BuildingAssets.store, g);
        backButton = new Button(50,50,150,150,"BACK",g);
        items = new ArrayList<>();
        this.graphics = g.getG();
        addItems();
    }
    
    
    public void addItems(){
        ArrayList<Pair> itemsData = new ArrayList<>();
        itemsData.add(new Pair("water","H20"));
        itemsData.add(new Pair("salt", "NaCl"));
        
        for(int i = 0; i < itemsData.size(); i++){
            Pair itemData = itemsData.get(i);
            StoreObject object = new StoreObject(i * 50, 200, (String)itemData.getKey(), (String)itemData.getValue(), i);
            items.add(object);
        }
    
    }
    
    public void renderStore(){
        showBackground();
        showBackButton();
        showStoreTitle();
        showItems();
    }
    
    public void showStoreTitle(){
        game.getG().drawImage(BuildingAssets.storeTitle,250,75,700,150,null);
        
    }
    
    public void showBackButton() {
        backButton.render(game.getG());
    }
    
    public void showBackground() {
        BufferedImage background = BuildingAssets.storeBackground;
        game.getG().drawImage(background, 0, 0, game.getWidth(), game.getWidth(), null);
    }

    public void showItems() {
        
        int columns = 4;
        int rows = 2;
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                int index = r * columns + c;
                if(index < items.size()){
                    StoreObject so = items.get(index);
                    game.getG().drawImage(so.getStoreIcon(), c * 300 + 50, 250 + r * 200, so.getHeight(), so.getWidth(), null);
                } else {
                    break;
                }
            }
        }
        
    }

    
}
