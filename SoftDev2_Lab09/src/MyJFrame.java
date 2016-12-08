import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;



public class MyJFrame extends JFrame {
	GameBoard gameboard= new GameBoard();

	GameRunner gameRunner;

	private int keyUp =38;
	private int keyDown= 40;
	private int keyLeft=37;
	private int keyRight=39;

	public MyJFrame(){
		initUI();
		placeComponents();
		bindListeners();

	}

	private void bindListeners() {
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				 onKey(arg0, true);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				 onKey(e, false);
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
			
		});
	}

	private void placeComponents() {
		this.getContentPane().add(gameboard);

	}

	private void initUI() {
		this.setSize(400, 400);
		this.setTitle("game 1");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		gameRunner = new GameRunner(gameboard);
		startGame();

	}

	private void startGame() {
		GameBoard.thread = new Thread(gameRunner);
		GameBoard.thread.start();

	}
	private void onKey(KeyEvent e, boolean yes){
		int keyCode = e.getKeyCode();
		
		if (keyCode == this.keyUp){
			GameBoard.shipUp(yes);
		}
		if(keyCode == this.keyDown){
			GameBoard.shipDown(yes);
		}
		if(keyCode == this.keyLeft){
			GameBoard.shipLeft(yes);
		}
		if(keyCode == this.keyRight){
			GameBoard.shipRight(yes);
		}
	}
}
