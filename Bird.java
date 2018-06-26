import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Rectangle;

public class Bird{
    
    private BufferedImage img;
    
    int Y;
    int X;
    int imgWidth;
int imgHeight;
    
    public Bird(int Y){
        try {
            img = ImageIO.read(new File("bird.png"));
        } catch (IOException ex) {
           System.out.println("Not supported");
        }
        
        this.Y = Y;
        X = 0;
        
        imgWidth = img.getWidth(null);
      imgHeight = img.getHeight(null);
    }
    
    
    
    
    public void drawItems(Graphics g){
        g.drawImage(img, X, Y, null);
       
        
    }
    
    public int getX(){
        return X;
    }
    
     public int getY(){
        return Y;
    }
       
    public void setY(int y){
        this.Y = y;
    }
          
    public void setX(int x){
        this.X = x;
    }
    
    
    
       public Rectangle getBounds(){
        return new Rectangle(X,Y,imgWidth,imgHeight);
       }
    
    
    
    
}