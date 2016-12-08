import java.awt.Graphics2D;
import java.awt.Shape;

public interface Actor extends Shape {
	public void tick();
	public void draw(Graphics2D g);

}
