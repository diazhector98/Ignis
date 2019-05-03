/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis.Worlds;

import ignis.Assets.Assets;
import ignis.Assets.TextAssets;
import ignis.Assets.WorldAssets.NonMetalWorldAssets;
import ignis.Atom;
import ignis.Enemy;
import ignis.Game;
import ignis.Platform;
import ignis.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author hectordiazaceves
 */
public class NonMetalWorld extends World {

    public NonMetalWorld(Game g, Player p) {
        super(g, p, 8);
        NonMetalWorldAssets.init();
    }

    @Override
    public void tick() {
        if (!paused) {
            tickAtoms();
            tickPlayer();
            tickEnemies();
            tickPlatforms();
            if (game.getKeyManager().space) {
                paused = true;
            }
        } else {
            pauseMenu.tick();
        }
    }

    @Override
    public void generateWorld() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 12; x++) {
                int pixel = NonMetalWorldAssets.world.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (getColor(red, green, blue).equals("WHITE")) {
                    platforms.add(new Platform(x * 100, y * 100, 100, 100, "STATIC", NonMetalWorldAssets.block));
                } else if (getColor(red, green, blue).equals("GREEN")) {
                    platforms.add(new Platform(x * 100, y * 100, 100, 100, "ACTIVE", NonMetalWorldAssets.block));
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (!paused) {
            g.drawImage(Assets.darkGraySquare, 0, 0, game.getWidth(), game.getHeight(), null);
            g.translate(-(player.getX() - 1200 / 2), -(player.getY() - 800 / 2));
            renderPlayerLives(g);
            renderAtoms(g);
            renderPlatforms(g);
            renderEnemies(g);
            renderPlayer(g);
        } else {
            showPauseMenu();
        }
    }

}
