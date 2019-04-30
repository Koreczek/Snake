package controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.Model;

public class Controller implements KeyListener{
	Model model;
	
	public Controller(Model m){
		this.model = m;
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			model.setSnakeDirection(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			model.setSnakeDirection(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			model.setSnakeDirection(2);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			model.setSnakeDirection(3);
		}
		
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
