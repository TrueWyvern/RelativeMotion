/*
    Matt, Aisik, Michelle, Liam
    2019-06-11
    This is the main class for the relative motion simulation
 */
package relativemotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lidea9928, malud0519
 */
public class RelativeMotion extends JPanel{

    /**
     * @param args the command line arguments
     */
    
    static int x,y;
    static int scale;
    Physics[] objects = new Physics[3];
    static Rocket rock;
    public static void main(String[] args) throws InterruptedException {
        // create a basic JFrame
        JFrame frame = new JFrame("JFrame Color Example");
        RelativeMotion panel = new RelativeMotion();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);
        scale = 4;
    // add panel to main frame
        frame.add(panel);
        frame.setVisible(true);

        x = (frame.getSize().width) / 2;
        y = (frame.getSize().height) / 2;
        
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                panel.draw();
                x = (frame.getSize().width) / 2;
                y = (frame.getSize().height) / 2;
                //frame.setSize(y,x);
            }
        });
        try {
            rock = new Rocket(0,0,0,0,2,0,20);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelativeMotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Objects 
        panel.objects[0] = new Physics (10,30,40,-5,5,-5,30);
        panel.objects[1] = new Physics(15,15,15,-2,7,-3,30);
        panel.objects[2] = new Physics(15,15,0,9,-2,3,30);
        
        //do stuff forever and ever
        while(true){
            for (int i=0; i<panel.objects.length; i++){
                panel.objects[i].go();
            }
            rock.go();
            panel.draw();
            Thread.sleep(300);
        }
        
        
        
        
    }
    /**
     * Paint
     * paints all onscreen objects
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
    g.setColor(Color.green);
    Graphics2D g2d = (Graphics2D) g;
    
    
//    for(int z = 0; z < 10; z++){
//        g.drawRect(RelativeMotion.x+(z*10), RelativeMotion.y+(z*10), RelativeMotion.x/25, RelativeMotion.y/25);
//    }
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 1000000, 10000000);
    
    g.setColor(Color.green);
    g.drawLine(RelativeMotion.x, RelativeMotion.y, RelativeMotion.x, RelativeMotion.y*2); //y-axis back
    g.drawLine(0,RelativeMotion.y,RelativeMotion.x,RelativeMotion.y); //x-axis back
    g.drawLine(RelativeMotion.x,RelativeMotion.y,RelativeMotion.x*2,0); //z-axis back
    
    
    //g.fillRect(TestGUI.x/3,TestGUI.y/3,TestGUI.x,TestGUI.y);
    g.drawRect(RelativeMotion.x, RelativeMotion.y, RelativeMotion.x/25, RelativeMotion.y/25);
    
    g.drawLine(RelativeMotion.x, 0, RelativeMotion.x, RelativeMotion.y); //y-axi front
    g.drawLine(RelativeMotion.x, RelativeMotion.y, RelativeMotion.x*2, RelativeMotion.y); //x-axi front
    g.drawLine(RelativeMotion.x, RelativeMotion.y, 0, RelativeMotion.y*2); //z-axi front 
    
    double theta = Math.atan((2*x)/(2*y));
    
    //paints objects
    int rocX = (int)(Math.round(rock.getX()) + Math.round(rock.getZ())+x);
    int rocY = (int)(Math.round(rock.getY()) - Math.round(rock.getZ())+y);
    g.drawRect(rocX, rocY, 5, 5);
    g.drawLine(rocX, rocY, rocX, (int) (rocY+rock.getY()));
    for(int i=0; i<objects.length; i++){
        int objscrnX = (int)(Math.round(objects[i].getX()) + Math.round(objects[i].getZ())+x);
        int objscrnY = (int)(Math.round(objects[i].getY()) - Math.round(objects[i].getZ())+y);
        g.drawOval(objscrnX, objscrnY, 5, 5);
        g.drawLine(objscrnX, objscrnY, objscrnX, (int)(objscrnY + objects[i].getY()));
    }   
    repaint();
  }
    
    
        
    
    /**
     * repaints the screen
     */
    public void draw(){
    repaint();
    }

    
    
    
}