import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Rectangle;


public class upsidePole extends Pole{
    
    private BufferedImage img2;
    

    public upsidePole(int x, int y){
    super(x,y);
    try {
            img2 = ImageIO.read(new File("upside.png"));
        } catch (IOException ex) {
           System.out.println("Not supported");
        }
    
    Ypos = y;
  
    }
   
        
        
        
    public void drawItems(Graphics g){
        g.drawImage(img2, Xpos, Ypos, null);
       
        
    }
}
