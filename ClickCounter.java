/*
Sai Avula
8.8.24
ClickCounter.java
Counting clicks
*/

import java.awt.Color;
import java.awt.Font;
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
        super.paintComponent(g);
        stars = clicked/5;
        circles = enter/6;
        Font f = new Font("Serif", Font.BOLD, 20);
        g.setFont(f);
        g.setColor(Color.BLACK);
        g.drawString("Inside", 20, 50);

        if(enter == 0 && clicked == 0)
        {
            setBackground(Color.blue);
            g.drawString("Inside", 20, 50);
            g.drawString( "Click Counter: " + clicked, 20 , 500);
            g.drawString( "Click Counter: " + clicked, 400 , 500);
            g.setColor(Color.yellow);
            int [] arx = new int[]{35, 29, 20, 27, 22, 35, 48, 44, 53, 43};
            int [] ary = new int[]{510, 520, 520, 530, 540, 530, 540, 530, 520, 520};
            g.setColor(Color.yellow);
            if (stars >= 1)g.fillPolygon(arx, ary, 10);
            for(int i = stars; i > 0; i--)
            {
                for(int n = 0; n < arx.length; n++)
                {
                    arx[n] =+ 40;
                }
                stars(arx, ary, 10, g);
            }
            int x = 400;
            int y = 510;
            g.setColor(Color.GREEN);
            if(circles >= 1)
            {
                g.fillOval(x, y, 30, 30);
            }
            for(int i = 0; i < circles -1; i ++)
            {
                x+=35;
                circles(x, y, g);
            }
        }

        else if( entered)
        {
            setBackground(Color.blue);
            g.drawString("Inside", 20, 50);
            g.drawString( "Click Counter: " + clicked, 20 , 500);
            g.drawString( "Inside counter " + enter, 400 , 500);
            int [] arx = new int[]{35, 29, 20, 27, 22, 35, 48, 44, 53, 43};
            int [] ary = new int[]{510, 520, 520, 530, 540, 530, 540, 530, 520, 520};
            g.setColor(Color.yellow);
            if (stars >= 1)g.fillPolygon(arx, ary, 10);
            for(int i = stars-1; i > 0; i--)
            {
                for(int n = 0; n < arx.length; n++)
                {
                    arx[n]+= 40;
                }
                stars(arx, ary, 10, g);
            }
            int x = 400;
            int y = 510;
            g.setColor(Color.GREEN);
            if(circles >= 1)
            {
                g.fillOval(x, y, 30, 30);
            }
            for(int i = 0; i < circles -1; i ++)
            {
                x+=35;
                circles(x, y, g);
            }
        }
        else if (!entered)
        {
            setBackground(Color.red);
            super.paintComponent(g);
            g.drawString("Outside", 20, 50);
            g.drawString( "Click Counter: " + clicked, 20 , 500);
            g.drawString( "Inside Counter: " + enter, 400 , 500);
            int [] arx = new int[]{35, 29, 20, 27, 22, 35, 48, 44, 53, 43};
            int [] ary = new int[]{510, 520, 520, 530, 540, 530, 540, 530, 520, 520};
            g.setColor(Color.yellow);
            if (stars >= 1)g.fillPolygon(arx, ary, 10);

            for(int i = stars-1; i > 0; i--)
            {
                for(int n = 0; n < arx.length; n++)
                {
                    arx[n]+=40;
                }
                stars(arx, ary, 10, g);
            }
            int x = 400;
            int y = 510;
            g.setColor(Color.GREEN);
            if(circles >= 1)
            {
                g.fillOval(x, y, 30, 30);
            }
            for(int i = 0; i < circles -1; i ++)
            {
                x+=35;
                circles(x, y, g);
            }

        }
    }
    public void circles(int x, int y, Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 30, 30);
    }
    public void stars(int [] ar1, int [] ar2, int numofsides, Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillPolygon(ar1, ar2, numofsides);
    }

    public void mouseEntered(MouseEvent e)
    {
        entered = true;
        enter++;
        repaint();
    }

    public void mouseExited(MouseEvent e)
    {
        entered = false;
        repaint();
    }

    public void mousePressed(MouseEvent evt) { }
    public void mouseClicked(MouseEvent evt)
    {
        if(entered) clicked ++;
        repaint();
    }
    public void mouseReleased(MouseEvent evt) { }
}