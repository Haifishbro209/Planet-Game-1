import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame{
 
 MyPanel panel;
 MyFrame(){
  panel = new MyPanel();
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setAlwaysOnTop(true);
  this.add(panel);
  this.pack();

  this.setLocationRelativeTo(null);
  this.setVisible(true);
 } 
 
}

class MyPanel extends JPanel{
    MyPanel(){
        this.setPreferredSize(new Dimension(500,500));
    }
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
    
        g2D.drawLine(0, 0, 500, 500);
    }
}
