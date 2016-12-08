import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Set;

public class Ship extends Polygon implements Actor{
	int vx=0;
	int vy=0;
	GameBoard gameBoard;

	static final int[] initxPoints ={-15,15,15,-15};
	static final int[] inityPoints ={-15,-15,15,15};

	public Ship(GameBoard gameBoard) {
		super(initxPoints,inityPoints,inityPoints.length);
		this.translate(300,200);
		this.gameBoard = gameBoard;
	}
	@Override
	public void tick(){
		this.translate(vx, vy);
		Set<Ball> temp = gameBoard.balls;

		for (Ball ball: temp){
			for (int i=0; i<inityPoints.length ;i++){
				
				if (ball.contains((double)xpoints[i],(double)ypoints[i])){
					if (ball.eatable == false){
						gameBoard.gameOver();
					}else{
						gameBoard.eatenBalls.add(ball);
					}
				}

			}
		}
	}

	@Override
	public void draw (Graphics2D g) {
		g.setColor(Color.black);
		g.fillPolygon(this);

	}

	public void moveUp(boolean yes){
		if (yes){
			vy= - GameBoard.shipspeed;
		}else{
			vy=0;
		}
	}
	public void moveDown(boolean yes){
		if (yes){
			vy= GameBoard.shipspeed;
		}else{
			vy=0;
		}
	}
	public void moveLeft(boolean yes){
		if(yes) {
			vx = -GameBoard.shipspeed;
		}else{
			vx=0;
		}
	}
	public void moveRight (boolean yes) {
		if(yes){
			vx= +GameBoard.shipspeed;
		}else{
			vx=0;
		}
	}

}
