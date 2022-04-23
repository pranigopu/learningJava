/*
<applet code="Cat.class" width=500 height=500>
</applet>
*/
import java.awt.Font; 
import java.awt.Color;  
import java.awt.Graphics;
import java.applet.Applet;
public class Cat extends Applet
{
    int x = 150, y = 150;
    int faceLength = 200;
    int faceHeight = 150;
    int earLength = 70;
    int earHeight = 70;
    int eyeLength = 50;
    int eyeHeight = 30;
    int noseLength = 50;
    public void face(Graphics g)
    {
        g.fillRect(x, y, faceLength, faceHeight);
    }
    public void mirrorPolygon(Graphics g, int xs[], int ys[], int sides, int start, int accrossDistance)
    {
        int new_xs[] = new int[sides];
        int compliment, excess;
        for(int i = 0; i < sides; i++)
        {
            compliment = start + accrossDistance - xs[i];
            excess = accrossDistance - compliment;
            new_xs[i] = start + accrossDistance - excess;
        }
        g.fillPolygon(new_xs, ys, sides);
    }
    public void mirrorOval(Graphics g, int this_x, int this_y, int length, int height, int start, int accrossDistance)
    {
        int compliment = start + accrossDistance - this_x;
        int excess = accrossDistance - compliment;
        excess += length;
        int new_x = start + accrossDistance - excess;
        g.fillOval(new_x, this_y, length, height);
    }
    public void ears(Graphics g)
    {
        int xs1[] = new int[]{x, x, x + earLength};
        int ys1[] = new int[]{y, y - earHeight, y};
        //Left ear
        g.fillPolygon(xs1, ys1, 3);
        //Right ear
        mirrorPolygon(g, xs1, ys1, 3, x, faceLength);
    }
    public void eyes(Graphics g)
    {
        //The irises
        g.setColor(Color.yellow);
        g.fillOval(x + 30, y + 50, eyeLength, eyeHeight);
        mirrorOval(g, x + 30, y + 50, eyeLength, eyeHeight, x, faceLength);
        //Now the eyeballs
        g.setColor(Color.black);
        g.fillOval(x + 30 + eyeLength / 2 - (eyeLength / 5) / 2, y + 50, eyeLength / 5, eyeHeight);
        mirrorOval(g, x + 30 + eyeLength / 2 - (eyeLength / 5) / 2, y + 50, eyeLength / 5, eyeHeight, x, faceLength);
    }
    public void nose(Graphics g)
    {
        int xs[] = new int[]{x + faceLength / 2 - noseLength / 2, x + faceLength / 2, x + faceLength / 2 + noseLength / 2};
        int ys[] = new int[]{y + 50 + eyeHeight + 15, y + 50 + eyeHeight + 15 + 20, y + 50 + eyeHeight + 15};
        g.setColor(Color.pink);
        g.fillPolygon(xs, ys, 3);
    }
    public void meow(Graphics g)
    {
        try
        {
            Font f = new Font("Times New Roman", Font.BOLD, 50);
            Color colors[] = new Color[]{Color.blue, Color.red, Color.green, Color.yellow};
            int i = 0;
            g.setFont(f);
            while(true)
            {
                if(i > 3)
                    i = 0;
                g.setColor(colors[i]);
                g.drawString("MEOW", 165, 400);
                Thread.sleep(200);
                i++;
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Goodbye!");
        }
    }
    public void paint(Graphics g)
    {
        Font f = new Font("Times New Roman", Font.BOLD, 20);
        g.setFont(f);
        try 
        {
            g.drawString("C", 160, 50);
            Thread.sleep(500);
            g.setColor(Color.black);
            face(g);
            Thread.sleep(500);

            g.drawString("for", 190, 50);
            Thread.sleep(500);
            ears(g);
            Thread.sleep(500);

            g.drawString("Cock", 230, 50);
            Thread.sleep(500);
            eyes(g);
            Thread.sleep(500);

            g.drawString("roach", 275, 50);
            Thread.sleep(500);
            nose(g);
            Thread.sleep(500);

            meow(g);
        }
        catch(InterruptedException e)
        {
            return;
        }
    }
}