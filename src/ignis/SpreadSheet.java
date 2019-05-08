/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jorge
 */
public class SpreadSheet {
    private BufferedImage sheet;

    /**
     *
     * @param sheet
     */
    public SpreadSheet(BufferedImage sheet)
    {
        this.sheet=sheet;
    }

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    public BufferedImage crop(int x,int y ,int width,int height)
    {
        return sheet.getSubimage(x,y,width,height);
    }
}
