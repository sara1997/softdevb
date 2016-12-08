package art;
import java.awt.Component;

import javax.swing.JFrame;
import art.*;
import temp.DisplayBasics;


public class BasicJFrame extends JFrame {

	public BasicJFrame(){
		super();
		initUI();
		placeComponents();
		bindListeners();
	}
	private void initUI() {
		this.setSize(400,400);
		this.setTitle("hellow");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	private void placeComponents() {
		BallDisplay ballDisplay= new BallDisplay();
		this.getContentPane().add(ballDisplay);
		
	}


	private void bindListeners() {
		// TODO Auto-generated method stub
		
	}

	
	
}
