/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;
import ignis.Game;
import java.awt.Graphics;
import ignis.Assets.SoundAssets;
import ignis.Worlds.World;
import java.util.ArrayList;
import java.util.Map;
/**
 *
 * @author Jorge
 */
public class InventoryMenu {
    private Game game;
    private Player player;
    private Button keepGoingButton;
    private Button goToMenuButton;
    private Button saveButton;
    private int MARGIN = 30;
    private MouseManager mouseManager;
    private ArrayList<InventoryItem> items;
    
   public InventoryMenu(Game g, Player p)
   {
       this.game = g;
        this.player = p;
        this.keepGoingButton = new Button(200 + MARGIN, 200 + MARGIN, 200, 100, "KEEPGOING", g);
        this.goToMenuButton = new Button(200 + MARGIN, 300 + MARGIN * 2, 200, 100, "GOTOMENU", g);
        this.saveButton = new Button(200 + MARGIN, 400 + MARGIN * 3, 200, 100, "SAVE", g);
        this.mouseManager = new MouseManager();
                
        
        this.game.getDisplay().getJframe().addMouseListener(mouseManager);
        this.game.getDisplay().getJframe().addMouseMotionListener(mouseManager);
        this.game.getDisplay().getCanvas().addMouseListener(mouseManager);
        this.game.getDisplay().getCanvas().addMouseMotionListener(mouseManager);
        
        this.items = new ArrayList<>();
        

        SoundAssets.init();
   }

    public void createItemListFromPlayer() {
        Map<String, Integer> playerAtoms = player.getAtoms();
        Object[] atomSymbols = playerAtoms.keySet().toArray();

        int columns = 8;
        int rows = 5;
        
        int n = atomSymbols.length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                int index = r * columns + c;
                if (index < n) {
                    String symbol = (String)atomSymbols[index];
                    int qty = playerAtoms.get(symbol);
                    int posX = c * 100 + 100;
                    int posY = 100 + r * 100;
                    InventoryItem item = new InventoryItem(posX, posY, 100, 150,symbol, qty);
                    this.items.add(item);
                } else {
                    break;
                }
            }
        }

    }
   public void tick()
   {
       if (mouseManager.isIzquierdo()) {
            int mouseX = mouseManager.getX();
            int mouseY = mouseManager.getY();
            if (posInButton(mouseX, mouseY, keepGoingButton)) {
                System.out.println("Keep Going Pressed");
                SoundAssets.click.play();
                game.unPause();
            }
              else if (posInButton(mouseX, mouseY, goToMenuButton)) {
                SoundAssets.click.play();
                System.out.println("Go to Menu Pressed");
                game.setInitialState();
             }
   }
   
   }
     private boolean posInButton(int x, int y, Button b) {
        int buttonX, buttonWidth, buttonY, buttonHeight;

        buttonX = b.getX();
        buttonWidth = b.getWidth();
        buttonY = b.getY();
        buttonHeight = b.getHeight();

        if (x < buttonX || x > buttonX + buttonWidth) {
            return false;
        }
        if (y < buttonY || y > buttonY + buttonHeight) {
            return false;
        }
        return true;
    }
      public void render(Graphics g){
        this.keepGoingButton.render(g);
        this.goToMenuButton.render(g);
        
    }
    }