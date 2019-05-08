/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import ignis.Assets.MenuAssets;

/**
 *
 * @author hectordiazaceves
 */
public class ControlsScreen {
        private Game game;
    private Player player;
    
    public ControlsScreen(Game g, Player p){
        this.game = g;
        this.player = p;
    }
    
    public void render() {
        game.getG().drawImage(MenuAssets.INSTRUCTIONS_WHOLE, 0, 0, game.getWidth(), game.getHeight(), null);
    }
}
