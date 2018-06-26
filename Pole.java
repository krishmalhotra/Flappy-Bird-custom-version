import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Rectangle;


public class Pole{
    
    private BufferedImage img;
    
    int Ypos;
    int Xpos;
    int width;
    int height;
    
    public Pole(int x,int y){
        try {
            img = ImageIO.read(new File("good pole.png"));
        } catch (IOException ex) {
           System.out.println("Not supported");
        }
        
        Ypos = y;
        Xpos= x;
        width = img.getWidth();
        height = img.getHeight();
        
    }

    
    
    
    public void drawItems(Graphics g){
        g.drawImage(img, Xpos, Ypos, null);
        System.out.print("Pole Height " + height+  " Pole width " + width);
       
        
    }
    
    public int getX(){
        return Xpos;
    }
    
     public int getY(){
        return Ypos;
    }
       
    public void setY(int y){
        this.Ypos = y;
    }
          
    public void setX(int x){
        this.Xpos = x;
    }
    

       public Rectangle getBounds(){
        return new Rectangle(Xpos,Ypos,width,height);
       }
    
    
    
    
}