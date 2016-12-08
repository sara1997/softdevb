package temp;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;



public class DisplayBasics extends JPanel{
	public DisplayBasics(){
		super();
	}
	@Override
	public void paint (Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.drawString("Hello World",250,150);
		g2.setColor(Color.GREEN);
		g2.fillOval(0,0,100,100);
		g2.setColor(Color.yellow);
		g2.fillOval(50,100,100,100);
		g2.setColor(Color.pink);
		g2.fillOval(100,200,100,100);
		g2.setColor(Color.blue);
		g2.fillOval(150,300,100,100);
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(10));
		g2.drawLine(100, 0, 300, 400);
		g2.setColor(Color.black);
		g2.draw(new Line2D.Float(150, 0,300,400));
	
		
		
		
	
		
	}
}


