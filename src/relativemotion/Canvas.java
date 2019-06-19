/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package relativemotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author aipil3692
 */

public class Canvas extends JPanel{
    Physics[] objects = new Physics[3];
    Canvas(){
        try {
            objects[0] = new Rocket(0,0,0,2,2,3,500);
            objects[1] = new Physics(3,3,3,12,12,12,30);
            objects[2] = new Physics(25,25,12,23,43,20,3);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void doStep(){
        for (int i=0; i<objects.length;i++){
        objects[i].go();

        }    
    }
    public void paint(Graphics g) {
    g.setColor(Color.green);
    Graphics2D g2d = (Graphics2D) g;
    
    
//    for(int z = 0; z < 10; z++){
//        g.drawRect(RelativeMotion.x+(z*10), RelativeMotion.y+(z*10), RelativeMotion.x/25, RelativeMotion.y/25);
//    }
    
    g.drawLine(RelativeMotion.x, RelativeMotion.y, RelativeMotion.x, RelativeMotion.y*2); //y-axis back
    g.drawLine(0,RelativeMotion.y,RelativeMotion.x,RelativeMotion.y); //x-axis back
    g.drawLine(RelativeMotion.x,RelativeMotion.y,RelativeMotion.x*2,0); //z-axis back
    
    
    //g.fillRect(TestGUI.x/3,TestGUI.y/3,TestGUI.x,TestGUI.y);
    g.drawRect(RelativeMotion.x, RelativeMotion.y, RelativeMotion.x/25, RelativeMotion.y/25);
    
    g.drawLine(RelativeMotion.x, 0, RelativeMotion.x, RelativeMotion.y); //y-axi front
    g.drawLine(RelativeMotion.x, RelativeMotion.y, RelativeMotion.x*2, RelativeMotion.y); //x-axi front
    g.drawLine(RelativeMotion.x, RelativeMotion.y, 0, RelativeMotion.y*2); //z-axi front 

    repaint();
  }
    
    
        
    public void trace(Physics object){
            double x = object.getX();
            double y = object.getY();
            double z = object.getZ();

            
    }
    
    public void draw(){
    repaint();
    }

    
}
