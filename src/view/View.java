package view;

import model.Model;
import model.Field;
import java.awt.*;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame{
	Model model = new Model();
	private LinkedList<Field> snake;
	private LinkedList<Field> eatenFood;
	public View(Model m) {
		
		this.setTitle("Snake");
		this.setSize(Model.size*20, Model.size*20);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = m;
		updateModel();
	}
	public void paint(Graphics g) {
		draw(g);
	}
	private void draw(Graphics g) { 
		updateModel();
		g.clearRect(0,0,getWidth(),getHeight());
		g.setColor(Color.black);
		for(int index = 0; index < snake.size(); index++) {
			putPoint(g, snake.get(index).getx(), snake.get(index).gety() );
		}
		if(eatenFood.size() != 0) {
			for(int index = 0; index < eatenFood.size(); index++) {
				putBigPoint(g, eatenFood.get(index).getx(), eatenFood.get(index).gety() );
			}
		}
		g.setColor(Color.red);
		putPoint(g, model.getFood().getx(), model.getFood().gety());

	}
	private void putBigPoint(Graphics g, int x2, int y2) {
		g.fillOval(20*x2, 20*y2, 20, 20);
		
	}
	private void putPoint(Graphics g, int x2, int y2) {
		g.fillOval(20*x2+2,20*y2+2,16,16);	
	}
	public void updateModel() {
		this.snake = model.getListOfSnakePoints();
		this.eatenFood = model.getEatenFood();
	}
	public void run() {
		model.move();
		this.repaint();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
