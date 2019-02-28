package model;

public class Field {
	private int x;
	private int y;
	
	public Field(int x, int y) {
		setposition(x, y);
	}
	public Field() {
		x = 0;
		y = 0;
	}
	public void setposition(int x, int y) { 
		this.x = x;
		this.y = y;			
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
}