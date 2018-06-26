import javax.swing.JFrame;     //class for main canvas(window)
import java.awt.*;

public class Client {
    
    public static void initializeJFrame(JFrame jf){
        
        jf.getContentPane().setBackground(Color.green);    //set color of main window
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the exit icon work correctly
        jf.setSize(600,700);                 //sets the size of the window
    //    jf.setLayout(new FlowLayout(0));
        jf.setLocationRelativeTo(null);                    //centers the window
        jf.setTitle("Flappy");                  // sets the title bar
        jf.setVisible(true);                              // makes the window visible
    }
    public static void main(String[] args) 
    {
        JFrame window = new JFrame();            //makes a jframe
                        
      
       Flappy panel1 = new Flappy();
        window.add(panel1);                 //adds the jpanel to your window
        
        initializeJFrame(window);    //initializes the window to your settings 
       
   
    }
}


