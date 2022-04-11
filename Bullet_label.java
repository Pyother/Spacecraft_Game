package racing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.util.Random;

public class Bullet_label extends JLabel
{
    public int myRandom1()
    {
        Random number = new Random();
        return number.nextInt(430);
    }//Function which gives random number from 0 to 430

    Bullet_label()
    {
        this.setBounds(myRandom1(), myRandom1(),40,40);
        //this.setBackground(Color.BLUE);
        //this.setOpaque(true);
        this.setVisible(true);
    }
}
