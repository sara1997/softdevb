import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;

public class GameBoard<Shipspeed> extends JPanel {
	static Ship ship;
	static final int NEWBALLEVERY =3000;
	static final int MAXNUMBEROFBALLS =10;
	public static final int FRAMERATE = 70;
	private static final int initialBalls = 1;
	static int shipspeed = 2; 
	static int MAXBALLSPEED =2;
	public Set<Actor> actors  = new HashSet<Actor>();
	public Set<Ball> balls = new HashSet<Ball>();
	public Set<Ball> eatenBalls = new HashSet<Ball>();
	int counter =NEWBALLEVERY;
	public static Thread thread;


	public GameBoard(){
		super();

		this.setBackground(Color.white);
		for(int i=0; i<initialBalls; i++){
			createBall();
		}
		ship = new Ship(this);
		actors.add(ship);

	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		for(Actor actor : actors){
			actor.draw(g2d);
		}
		g2d.setColor(Color.WHITE);
		int locX = this.getWidth()/2 -120;
		int locY = this.getHeight()/2;
		//g2d.drawString( locX, locY);
	}


	public void createBall(){
		if (balls.size()< MAXNUMBEROFBALLS){
			Ball b = new Ball(this);
			actors.add(b);
			balls.add(b);
		}
	}
	public void moveAll(){
		for(Actor actor : actors){
			actor.tick();
		}
		removeEatenBalls();
		
		counter -= 1000/FRAMERATE;
		if (counter <0){
			counter = NEWBALLEVERY;
			createBall();
		}
		this.repaint();
	}
	public void removeEatenBalls(){
		actors.removeAll(eatenBalls);
		balls.removeAll(eatenBalls);
		eatenBalls.clear();
	}
	public static void shipUp(boolean yes){
		ship.moveUp(yes);
	}
	public static void shipDown(boolean yes){
		ship.moveDown(yes);
	}
	public static void shipLeft(boolean yes){
		ship.moveLeft(yes);
	}
	public static void shipRight(boolean yes){
		ship.moveRight(yes);
	}

	public void gameOver(){
		boolean gameOver = true;
		System.out.println("gameOver");
		thread.interrupt();

	}
}