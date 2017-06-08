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
public class Tiro extends JPanel {

    private int x;
    private int y;
    
    private static final int dx = 5;
    private static final int dy = 30;

    public Tiro() {
        setBounds(0, 0, dx, dy);
        setBackground(Color.RED);
    }

    public Tiro(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, dx, dy);
        setBackground(Color.RED);
    }

    /*
    public void moveX(int x) {
        setBounds((this.x += x), y, dx, dy);
    }
     */
    
    public void moveY(int y) {
        setBounds(x, (this.y += y), dx, dy);
    }

}
