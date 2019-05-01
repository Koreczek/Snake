package model;

public class Field {
	private int x;
	private int y;
	private int kindOfField; //0 - free, 1 - snake, 2 - food, 3 - wall
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
	public boolean isEqual(Field f) {
		if (this.getx() == f.getx() && this.gety() == f.gety()) {
			return true;
		}
		return false;
	}
}