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
public class Jogador extends JPanel {

    private int x;
    private int y;
    
    private static final int dx = 50;
    private static final int dy = 25;

    public Jogador() {
        setBounds(0, 0, dx, dy);
        setBackground(Color.ORANGE);
    }

    public Jogador(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, dx, dy);
        setBackground(Color.ORANGE);
    }

    public void moveX(int x) {
        setBounds((this.x += x), y, dx, dy);
    }

    public void moveY(int y) {
        setBounds(x, (this.y += y), dx, dy);
    }

}
