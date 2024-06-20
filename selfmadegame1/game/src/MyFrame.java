import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

public class MyFrame extends JFrame implements KeyListener {

    MyPanel panel;

    MyFrame() {
        panel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == ' ') {
            panel.launchRocket();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyPanel extends JPanel {

    private double roketAngle = 0;
    private Timer timer;
    int roketWidth = 47;
    int roketHeight = 140;
    int panelX = 1000;
    int panelY = 1000;
    Image roketImage = new ImageIcon("roket140.png").getImage();
    Image planet = new ImageIcon("planet200x200.png").getImage();
    Image space = new ImageIcon("space1000x1000.png").getImage();
    int planetWidth = 200;
    int planetHeight = planetWidth;
    int planetX = (panelX - planetWidth) / 2;
    int planetY = planetX;
    int roketX = (panelX - roketWidth) / 2;
    int roketY = (panelY - roketHeight) / 2;

    MyPanel() {
        this.setPreferredSize(new Dimension(panelX, panelY));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(space, 0, 0, null);
        g2D.drawImage(planet, planetX, planetY, null);

        AffineTransform old = g2D.getTransform();
        g2D.rotate(Math.toRadians(roketAngle), roketX + roketWidth / 2, roketY + roketHeight / 2);
        g2D.drawImage(roketImage, roketX, roketY, null);
        g2D.setTransform(old);
    }

    

    public void launchRocket() {
        System.out.println("Rocket Launched");
        if (timer == null) {
            timer = new Timer(333, e -> {
                roketAngle += 45; 
                if (roketAngle >= 360) {
                    roketAngle = 0;
                }
                repaint();
            });
            timer.start();
        }
    }
}
