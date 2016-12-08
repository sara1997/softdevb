package art;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Ball {

	float x,y,vx,vy;
	Color color;
	int width,height;
	public Ball(int x, int y){
		this.x = x;
		this.y = y;
		this.vx = 1;
		this.vy = 0.5f;
		this.vy = 50;
		this.width=50;
		this.height=50;
		this.color=Color.RED;
	}
	public void draw (Graphics2D g){
		g.setColor(color);
		g.fillOval((int)x, (int)y, width, height);
		
	}
	public void tick(JPanel boundingPanel){
		x+=vx;
		y+=vy;
		
		
	}
}
