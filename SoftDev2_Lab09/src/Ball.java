import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball extends java.awt.geom.Ellipse2D.Double implements Actor{
	private static long BALLCOUNT = 0;
	public  final long id =BALLCOUNT++;
	public static final Color[] COLORS = {Color.GREEN,Color.ORANGE}; 
	Color color;
	GameBoard gameBoard;
	double size;
	double vx, absVx;
	double vy, absVy;
	boolean eatable = true;
	

	public Ball(GameBoard gameBoard){
		super();
		this.gameBoard = gameBoard;
		Random randomgenerator =new Random();
		int numberOfColors = COLORS.length;
		int colorNumber = randomgenerator.nextInt(numberOfColors); 
		color= COLORS[colorNumber];
		if (colorNumber == 1){eatable = false;}
		this.size = 30 + randomgenerator.nextDouble()*70;
		this.width = this.size;
		this.height = this.size;

		this.x = 50;
		this.y = 50;

		//move to an edge
		if (randomgenerator.nextInt(2) ==0){
			// to the side
			// this maths puts the ball over the edge so that it comes in from the sides
			//ie 0-ballSize
			//or boardWidth+size-size = boardWidth
			this.x = randomgenerator.nextInt(2)*(gameBoard.getWidth()+this.size)-this.size;
			this.y = randomgenerator.nextDouble()*(gameBoard.getHeight()-this.size);
		}else{
			//top or bottom
			this.x = randomgenerator.nextDouble()*(gameBoard.getWidth()-this.size);
			this.y = randomgenerator.nextInt(2)*(gameBoard.getHeight()+this.size)-this.size;
	     	}
		
		absVx = gameBoard.MAXBALLSPEED * randomgenerator.nextDouble();
		vx = absVx * (-1 + (randomgenerator.nextInt(2)*2));
		absVy = gameBoard.MAXBALLSPEED * randomgenerator.nextDouble();
		vy = absVy * (-1 + (randomgenerator.nextInt(2)*2));
	}
	@Override
	public void tick(){
		this.x +=vx;
		this.y +=vy;
		//System.out.println("tick ball "+vy);
		if (x<0 ) {vx = absVx;}
		if (x > gameBoard.getWidth()-size){
			vx =-absVx;
		}
		if (y< 0){vy = absVy;}
		if (y > gameBoard.getHeight()-size ){vy = -absVy;}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(this.color);
		g.fill(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result ;
		result =  (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ball other = (Ball) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString(){
		return "ball id "+id;
	}
	
}
