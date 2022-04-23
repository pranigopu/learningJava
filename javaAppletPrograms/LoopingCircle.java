/* 
<applet code="LoopingCircle" width=300 height=250>
</applet>
*/
import java.awt.Color;  
import java.awt.Graphics;
import java.applet.Applet;  
public class LoopingCircle extends Applet  
{  
    public void paint(Graphics g)
    {
        int a=150,b=150,c=10,d=10;
        g.setColor(Color.red);
        for(int i = 0; i < 15; i++)
        {
            try
            {
                Thread.sleep(200);
            }
            catch(InterruptedException ex){}
            g.drawOval(a,b,c,d);
            a -= 10;
            b -= 10;
            c += 8;
            d += 8;
        }
    }
}