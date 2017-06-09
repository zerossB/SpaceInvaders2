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

    private boolean vivo;

    private static final int dx = 30;
    private static final int dy = 30;

    public Inimigo() {
        setBounds(0, 0, dx, dy);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
    }

    public Inimigo(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, dx, dy);
        setBackground(Color.WHITE);
    }

    public void moveX(int x) {
        setBounds((this.x += x), y, dx, dy);
    }

    public void moveY(int y) {
        setBounds(x, (this.y += y), dx, dy);
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}
