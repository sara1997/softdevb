package art;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BallDisplay extends JPanel {
	Ball ball;
	public BallDisplay(){
		ball=new Ball(100,100);
	}
	@Override
	public void paint(Graphics g){
		Graphics2D g2= (Graphics2D) g;
		ball.draw(g2);
	
	}
	
	public void tickAll(JPanel boundingPanel){
		
	
	}
}
