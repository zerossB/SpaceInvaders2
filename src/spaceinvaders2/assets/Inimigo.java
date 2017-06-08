/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders2.assets;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author haynes
 */
public class Inimigo extends JPanel {

    private int x;
    private int y;

    public Inimigo() {
        setBounds(0, 0, 30, 30);
        setBackground(Color.WHITE);
    }

    public Inimigo(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, 30, 30);
        setBackground(Color.WHITE);
    }

    public void moveX(int x) {
        setBounds((this.x += x), y, 30, 30);
    }

    public void moveY(int y) {
        setBounds(x, (this.y += y), 30, 30);
    }

}
