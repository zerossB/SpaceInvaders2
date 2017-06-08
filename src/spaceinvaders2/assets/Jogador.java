/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders2.assets;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author haynes
 */
public class Jogador extends JPanel {

    private int x;
    private int y;

    public Jogador() {
        setBounds(0, 0, 50, 50);
        setBackground(Color.ORANGE);
    }

    public Jogador(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, 50, 50);
        setBackground(Color.ORANGE);
    }

    public void moveX(int x) {
        setBounds((this.x += x), y, 50, 50);
    }

    public void moveY(int y) {
        setBounds(x, (this.y += y), 50, 50);
    }

}
