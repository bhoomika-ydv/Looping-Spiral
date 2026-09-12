import javax.swing.*;
import java.awt.*;

public class Spiral extends JPanel implements Runnable {
    int steps = 45;
    int current = 0;

    public Spiral(){
        new Thread(this).start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int cx = getWidth()/2 - 25;
        int cy = getHeight()/2 - 25;
        int[][] start = {{20,20},{getWidth()-100,20},{20,getHeight()-120},{getWidth()-100,getHeight()-120}};
        Color[] colors = {Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE};

        for(int c=0;c<4;c++){
            g.setColor(colors[c]);
            for(int i=0;i<=current;i++){
                int x = start[c][0] + (cx - start[c][0]) * i / steps;
                int y = start[c][1] + (cy - start[c][1]) * i / steps;
                g.drawOval(x,y,20+i*2,20+i*2);
            }
        }
    }
    public void run(){
        try{
            for(current=0; current<=steps; current++){
                repaint();
                Thread.sleep(100);
            }
        }catch(Exception e){}
    }
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(new Spiral());
        f.setSize(800,600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}