/*
Sai Avula
8.8.24
ClickCounter.java
Counting clicks
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickCounter extends JFrame
{

    public static void main (String [] args)
    {
        ClickCounter hg2016 = new ClickCounter();
        hg2016.run();
    }
    public void run()
    {
        JFrame frame = new JFrame("");
        frame.setSize( 600, 600);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // or JFrame.EXIT_ON_CLOSE); or frame.EXIT_ON_CLOSE);
        frame.setLocation(400,50);
        frame.setResizable(true);
        HGPanel hgp = new HGPanel();
        frame.setContentPane( hgp );  // OR frame.getContentPane().add(p_in);
        frame.setVisible(true);
    }
}

class HGPanel extends JPanel implements MouseListener
{
    private boolean entered;
    private int enter, clicked, stars, circles;

    public HGPanel() //constructor -sets the panel to listen for mouse events on itself (using "this" )
    {
        entered = false;
        enter = 0;
        clicked = 0;

        addMouseListener(this);
        setBackground(Color.MAGENTA);
    }
    public void paintComponent(Graphics g)
    {
        
    }
    public void circles(int x, int y, Graphics g){}
    public void stars(int [] ar1, int [] ar2, int numofsides, Graphics g){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent evt) { }
    public void mouseClicked(MouseEvent evt){}
    public void mouseReleased(MouseEvent evt) { }
}