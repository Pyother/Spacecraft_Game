package racing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game_Frame extends JFrame implements KeyListener
{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    //JLabel label6;
    Bullet_label[] bullet_label;
    ImageIcon image1;
    ImageIcon image2;
    ImageIcon image3;
    ImageIcon image4;
    ImageIcon image5;
    ImageIcon image6;
    ImageIcon image7;
    Border border;
    int x=myRandom1();
    int y=myRandom1();
    int score=0;
    Timer timer1 = new Timer();
    Timer timer2 = new Timer();
    int index=0;

    public void catching_stars()
    {
        if(label1.getX() > (label2.getX() - 40) && label1.getX() < (label2.getX() + 40) && label1.getY() > (label2.getY() - 40) && label1.getY() < (label2.getY() + 40))
        {
            score++;
            label3.setText("Score: "+score);
            label2.setLocation(myRandom1(),myRandom1());
        }
    }//Function which is responsible for collecting stars

    public int myRandom1()
    {
        Random number = new Random();
        return number.nextInt(430);
    }//Function which gives random number from 0 to 430

    public int myRandom2()
    {
        Random number = new Random();
        return number.nextInt(-20,20);
    }//Function which gives random number from -20 to 20

    TimerTask opponent_move = new TimerTask() {
        @Override
        public void run() {
            if(index<10) {
                    if(bullet_label[index].getX()<label1.getX()&& bullet_label[index].getY()<label1.getY()) bullet_label[index].setLocation(bullet_label[index].getX()+10, bullet_label[index].getY()+10);
                    if(bullet_label[index].getX()<label1.getX()&& bullet_label[index].getY()>label1.getY()) bullet_label[index].setLocation(bullet_label[index].getX()+10, bullet_label[index].getY()-10);
                    if(bullet_label[index].getX()>label1.getX()&& bullet_label[index].getY()<label1.getY()) bullet_label[index].setLocation(bullet_label[index].getX()-10, bullet_label[index].getY()+10);
                    if(bullet_label[index].getX()>label1.getX()&& bullet_label[index].getY()>label1.getY()) bullet_label[index].setLocation(bullet_label[index].getX()-10, bullet_label[index].getY()-10);
                else {
                    timer1.cancel();
                }

            }
        }
    };//Function that determines opponent behaviour

    /*TimerTask new_bullet = new TimerTask() {
        @Override
        public void run() {
            Bullet_label bullet_label= new Bullet_label();
            label4.add(bullet_label);
        }
    };//Function that determines opponent behaviour*/

    Game_Frame()
    {
        //Components declaration
        image1 = new ImageIcon("rocket_02.png");
        image2 = new ImageIcon("star.png");
        image3 = new ImageIcon("star_sky.png");
        image4 = new ImageIcon("game_icon.png");
        image5 = new ImageIcon("bomb.png");
        image6 = new ImageIcon("alien.png");
        image7 = new ImageIcon("rocket_02_down.png");
        border = BorderFactory.createLineBorder(Color.cyan,3);

        //Frame declaration
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SPACECRAFT");
        this.setSize(540,540);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.getRootPane().setBorder(border);
        this.addKeyListener(this);
        this.setResizable(false);

        //Label 1 declaration(Rocket)
        label1 = new JLabel();
        label1.setIcon(image1);
        label1.setBounds(0,0,60,60);
        label1.setVisible(true);

        //Label 2 declaration(Star)
        label2 = new JLabel();
        label2.setIcon(image2);
        label2.setBounds(x, y,40,40);
        label2.setVisible(true);

        //Label 3 declaration(Score)
        label3 = new JLabel();
        label3.setText("Score: "+score);
        label3.setBounds(465,0,150,30);
        label3.setBackground(new Color(77, 93, 100));
        label3.setVisible(true);
        label3.setHorizontalTextPosition(JLabel.CENTER);
        label3.setVerticalTextPosition(JLabel.BOTTOM);
        label3.setForeground(Color.WHITE);
        //label3.setBorder(border);
        label3.setVisible(true);

        //Label 4 declaration(Cosmos)
        label4 = new JLabel();
        label4.setIcon(image3);
        label4.setBounds(0, 0,540,540);
        label4.setVisible(true);

        //Label 5 declaration(Enemy)
        label5 = new JLabel();
        label5.setBounds(myRandom1(), myRandom1(),80,40);
        label5.setIcon(image6);
        label5.setVisible(true);

        /*//Label 6 declaration(Enemy's bullet)
        label6 = new JLabel();
        label6.setBounds(label5.getX()-20, label5.getY()+20,40,40);
        label6.setBackground(Color.BLUE);
        label6.setOpaque(true);
        label6.setVisible(true);*/

        //Bullet Label
        bullet_label = new Bullet_label[10];
        for(int i=0; i<10; i++)
        {
            bullet_label[i] = new Bullet_label();
            bullet_label[i].setLocation(label5.getX()-20,label5.getY()+20);
            bullet_label[i].setIcon(image5);
        }

        //Adding components to the frame
        this.add(label4);
        label4.add(label1);
        label4.add(label2);
        label4.add(label3);
        label4.add(label5);
        //label4.add(label6);
        label4.add(bullet_label[index]);
        this.setVisible(true);

        timer1.scheduleAtFixedRate(opponent_move, 0, 80);
        opponent_move.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar())
        {
            case 'a': {
                if(label1.getX()>0) {
                    label1.setIcon(image1);
                    label1.setLocation(label1.getX() - 10, label1.getY());
                }
                catching_stars();
                break;
            }
            case 'w': {
                if (label1.getY() > -30) {
                    label1.setIcon(image1);
                    label1.setLocation(label1.getX(), label1.getY() - 10);
                }
                catching_stars();
                break;
            }
            case 's': {
                if (label1.getY() < 430) {
                    label1.setIcon(image7);
                    label1.setLocation(label1.getX(), label1.getY() + 10);
                }
                catching_stars();
                break;
            }
            case 'd': {
                if (label1.getX() < 480) {
                    label1.setIcon(image1);
                    label1.setLocation(label1.getX() + 10, label1.getY());
                }
                catching_stars();
                break;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case 37: {
                if (label1.getX() > 0) label1.setLocation(label1.getX() - 10, label1.getY());
                catching_stars();
                break;
            }
            case 38: {
                if (label1.getY() > -30) label1.setLocation(label1.getX(), label1.getY() - 10);
                catching_stars();
                break;
            }
            case 40: {
                if (label1.getY() < 430) label1.setLocation(label1.getX(), label1.getY() + 10);
                catching_stars();
                break;
            }
            case 39: {
                if (label1.getX() < 480) label1.setLocation(label1.getX() + 10, label1.getY());
                catching_stars();
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key number: " +e.getKeyCode());
        System.out.println("Key number: " +e.getKeyChar());
    }


}
