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
    private MouseManager mouseManager;
    private boolean onPreview;
    private StoreObject selectedObject;
    private StoreItemScreen itemScreen;
    private int buttonTimer;
    
    public Store(int x, int y, int width, int height, Game g) {
        super(x, y, width, height, BuildingAssets.store, g);
        this.backButton = new Button(50,50,150,150,"BACK",g);
        this.items = new ArrayList<>();
        this.graphics = g.getG();
        this.mouseManager = new MouseManager();
        
        this.game.getDisplay().getJframe().addMouseListener(mouseManager);
        this.game.getDisplay().getJframe().addMouseMotionListener(mouseManager);
        this.game.getDisplay().getCanvas().addMouseListener(mouseManager);
        this.game.getDisplay().getCanvas().addMouseMotionListener(mouseManager);
        addItems();
        
        this.buttonTimer = 0;
        
        this.onPreview = false;
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
    
    public void renderStore() {

        if (!onPreview) {
            showBackground();
            showBackButton();
            showStoreTitle();
            showItems();
        } else {
            showItemPreview();
        }

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
                    so.setX(c * 300 + 50);
                    so.setY(250 + r * 200);
                } else {
                    break;
                }
            }
        }   
    }
    
    public void tick() {
        buttonTimer = buttonTimer > 0 ? buttonTimer - 1: 0;
        if(onPreview){
            tickPreview();
        } else {
            tickStore();
        }
    }
    
    
    public void tickStore() {
        if(mouseManager.isIzquierdo() && buttonTimer == 0){
            buttonTimer = 25;
            int mouseX = mouseManager.getX();
            int mouseY = mouseManager.getY();
            for(StoreObject so : items){
                if(posInObject(mouseX,mouseY, so)){
                    itemScreen = new StoreItemScreen(so, this.game);
                    onPreview = true;
                    selectedObject = so;
                }
            }
            if(posInButton(mouseX,mouseY, backButton)){
                System.out.println("Back to menu");
                game.setOnStore(false);
            }
        }
    }
    
    public void tickPreview(){
        if(mouseManager.isIzquierdo() && buttonTimer == 0){
            buttonTimer = 25;
            int mouseX = mouseManager.getX();
            int mouseY = mouseManager.getY();
            if(posInButton(mouseX, mouseY, itemScreen.getBuyButton())){
                System.out.println("Buy object!");
            }
            if(posInButton(mouseX, mouseY, itemScreen.getBackButton())){
                System.out.println("Return to store");
                onPreview = false;
            }
        }
    }
    
    public void showItemPreview(){
        game.getG().drawImage(itemScreen.getBackground(), 0, 0, game.getWidth(), game.getHeight(), null);
        itemScreen.getBackButton().render(game.getG());
        game.getG().drawImage(itemScreen.getObjectTitle(), 300, 75, 600, 200, null);
        itemScreen.getBuyButton().render(game.getG());
    }
    
    private boolean posInObject(int x, int y, StoreObject so) {
        int storeObjectX, storeObjectWidth, storeObjectY, storeObjectHeight;

        storeObjectX = so.getX();
        storeObjectWidth = so.getWidth();
        storeObjectY = so.getY();
        storeObjectHeight = so.getHeight();

        if (x < storeObjectX || x > storeObjectX + storeObjectWidth) {
            return false;
        }
        if (y < storeObjectY || y > storeObjectY + storeObjectHeight) {
            return false;
        }
        return true;
    }
    
    private boolean posInButton(int x, int y, Button button) {
        int buttonX, buttonWidth, buttonY, buttonHeight;

        buttonX = button.getX();
        buttonWidth = button.getWidth();
        buttonY = button.getY();
        buttonHeight = button.getHeight();

        if (x < buttonX || x > buttonX + buttonWidth) {
            return false;
        }
        if (y < buttonY || y > buttonY + buttonHeight) {
            return false;
        }
        return true;
    }

    
}
