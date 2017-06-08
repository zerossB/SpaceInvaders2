package spaceinvaders2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import spaceinvaders2.assets.Inimigo;
import spaceinvaders2.assets.Jogador;
import spaceinvaders2.assets.Tiro;

/**
 *
 * @author haynes
 */
public class SpaceInvaders2 extends JFrame {

    //Paineis
    private JPanel pGame;
    private JPanel pInfo;

    //Personagens
    private Jogador jogador;

    private Inimigo inimigo;

    //Velocidade de Movimento
    private final int vX = 5;
    private final int vY = 3;

    //Thread Tiro
    private Thread thTiro;

    public SpaceInvaders2() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Space Invaders 2");
        setSize(500, 400);

        setLocationRelativeTo(null);

        addKeyListener(new JogadorKeyListener());

        init();
    }

    private void init() {
        pGame = new JPanel();
        pInfo = new JPanel();

        pGame.setLayout(null);

        pGame.setBackground(Color.BLACK);

        //Centralizando Jogador no meio da base inferior
        int x = (getWidth() / 2) - 25;
        int y = (getHeight() - 100);
        jogador = new Jogador(x, y);
        pGame.add(jogador);

        inimigo = new Inimigo(30, 30);
        pGame.add(inimigo);

        add(pGame, BorderLayout.CENTER);
        add(pInfo, BorderLayout.PAGE_END);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpaceInvaders2 app = new SpaceInvaders2();
        app.setVisible(true);
    }

    private class JogadorKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {

                //Movimento para Esquerda
                case KeyEvent.VK_LEFT:
                    if (jogador.getBounds().x != 0) {
                        jogador.moveX(-vX);
                    }
                    pGame.repaint();
                    break;

                //Movimento para a Direita
                case KeyEvent.VK_RIGHT:
                    if (jogador.getBounds().x != getWidth() - 50) {
                        jogador.moveX(vX);
                    }
                    pGame.repaint();
                    break;

                //Tiro, Tiro
                case KeyEvent.VK_SPACE:
                    thTiro = new Thread(new TiroThread());
                    thTiro.start();
                    break;
            }
        }
    }

    private class TiroThread implements Runnable {

        @Override
        public void run() {
            //Configurações do Tiro
            int y = jogador.getBounds().y - 25;
            int x = (jogador.getBounds().x + ((jogador.getBounds().width / 2) - 3));

            //Instancia do Tiro
            Tiro tiro = new Tiro(x, y);
            pGame.add(tiro);
            pGame.repaint();

            //Faz Tiro se mexer no eixo Y
            while (true) {
                try {

                    if (tiro.getBounds().intersects(inimigo.getBounds())) {
                        pGame.remove(inimigo);
                        pGame.remove(tiro);
                    }

                    //É diferente que a altura do tiro negativa? (Fora da tela)
                    if (tiro.getBounds().y != -tiro.getHeight()) {
                        tiro.moveY(-vY);
                    } else {//Reomvendo componente e liberando memória!
                        pGame.remove(tiro);
                        System.out.println("Removeu");
                        break;
                    }
                    pGame.repaint();
                    Thread.sleep(100); //"FPS"
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}
