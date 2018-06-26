
/*
Krish Malhotra
Final AP Computer Science project
06/06/2018
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

public class Flappy extends JPanel implements ActionListener {

    Timer clock;
    Bird bird;
    Pole pole;
    upsidePole pole2;
    Pole pole3;
    upsidePole pole4;
    Image bgImage;
    int level;
    int pass;
    boolean end;
    int score;

    public Flappy() {
        //Sets background image
        MediaTracker mt = new MediaTracker(this);
        bgImage = Toolkit.getDefaultToolkit().getImage("download.jpg");
        mt.addImage(bgImage, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException e) {
            System.out.println("error e");
        }

        score = 0;
        clock = new Timer(60, this);
        clock.start();
        bird = new Bird(400);
        pole = new Pole(600,500);
        pole2 = new upsidePole(600,0);
        pole3 = new Pole(1000,400);
        pole4 = new upsidePole(1000,-100);

        Dimension dim = new Dimension(600, 700);

        this.setPreferredSize(dim);
        this.setSize(dim);
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);
        this.setFocusable(true);

    }

    // resets game related info once game has ended
    public void reset() {
        bird.setY(400);
        level = 0;
        pole.setX(600);
        pole2.setX(600);
        pole3.setX(1000);
        pole4.setX(1000);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, 600, 800, null);
        bird.drawItems(g);
        pole.drawItems(g);
        pole2.drawItems(g);
        pole3.drawItems(g);
        pole4.drawItems(g);
        // Displays score during gameplay
        g.setFont(new Font("custom", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString("" + score, 280, 200);
        // print game over and instructs on 
        //how to restart the game once game is finished
        if (end == true) {
            g.setFont(new Font("custom", Font.BOLD, 70));
            g.setColor(Color.black);
            g.drawString("GAME OVER!", 10, 300);
            g.drawString("Score :" + score, 10, 375);
            g.setFont(new Font("custom", Font.BOLD, 20));
            g.drawString("Press the Spacebar to play again", 10, 500);
            clock.stop();

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // increases the level in order to increase speed of poles
        if (pass == 5) {
            level++;
            pass = 0;

        }
        // moves poles towards birds, pole moves faster as score reaches higher
        pole.setX(pole.getX() - ((level * 2) + 10));
        pole2.setX(pole2.getX() - ((level * 2) + 10));
        pole3.setX(pole3.getX() - ((level * 2) + 10));
        pole4.setX(pole4.getX() - ((level * 2) + 10));
        // bird constantly falls at a slow rate due to gravity in the game
        bird.setY(bird.getY() + 3);
        //top boundaries for bird
        if (bird.getY() >= 600) {
            bird.setY(600);
        }
        // bottom boundaries for bird
        if (bird.getY() <= 0) {
            bird.setY(0);
        }
        // if poles reach -200, bird has made it past the poles
        // score increases
        //the pole heights are randomized and return into game
        if (((pole.getX() <= -200) && (pole2.getX() <= -200))) {

            score++;
            pass++;
            pole.setX(600);
            pole2.setX(600);
            // randomization of poles
            int rand = (int) (Math.random() * 250) + 350;
            int dif = 150;
            int rand2 = rand - dif;
            rand2 = rand2 - 347;
            // reduces distance of top pole from boundaries if it has opening on top
            if(rand2>0){
                int space = Math.abs(0- rand2);
                space = space /2;
                rand -= space;
                rand2 -= space;
            }


            pole.setY(rand);
            pole2.setY(rand2);
        }

        if (((pole3.getX() <= -200) && (pole4.getX() <= -200))) {

            score++;
            pole3.setX(600);
            pole4.setX(600);
            int rand = (int) (Math.random() * 250) + 350;
            int dif = 150;
            int rand2 = rand - dif;
            rand2 = rand2 - 347;
            
            if(rand2>0){
                int space = Math.abs(0- rand2);
                space = space /2;
                rand -= space;
                rand2 -= space;
            }

            pole3.setY(rand);
            pole4.setY(rand2);

            // 347 pole height   
        }

        // checks for collision between bird and any pole
        if ((bird.getBounds().intersects(pole.getBounds()))
                || (bird.getBounds().intersects(pole2.getBounds()))
                || (bird.getBounds().intersects(pole3.getBounds()))
                || (bird.getBounds().intersects(pole4.getBounds()))) {
            System.out.println();
            System.out.println(pole2.getY());
            System.out.println(pole4.getY());

            end = true;
            reset();

        }

        repaint();

    }

    @Override
    public void addNotify() {
        super.addNotify();
        addKeyListener(new KeyHandler());
    }

    public class KeyHandler extends KeyAdapter implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            String key = KeyEvent.getKeyText(e.getKeyCode());

            if (key.equals("Up")) { // Right arrow key
                bird.setY(bird.getY() - 10);

            }

            if (key.equals("Down")) {
                bird.setY(bird.getY() + 10);
            }

            // allows game to restart
            if (key.equals("Space") && end == true) {
                end = false;
                clock.start();
                score = 0;
                reset();

            }

            repaint();
            System.out.println(e + " keypress");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            repaint();
            System.out.println(e + " keyReleased");
        }

        @Override
        public void keyTyped(KeyEvent e) {
            repaint();
            System.out.println(e + " keyTyped");
        }

    }
}
