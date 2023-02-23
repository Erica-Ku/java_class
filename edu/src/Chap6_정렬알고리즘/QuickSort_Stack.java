package Chap6_정렬알고리즘;

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}
	
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

public class QuickSort_Stack {
	private int top;
	private Point [] data;
	
	public QuickSort_Stack(int i) {
		top = 0;
		data = new Point[i];
	}
	
	public void push(Point p) {
		data[top++] = p;
	}
	
	public Point pop() {
		return data[--top];
	}
	
	public boolean isEmpty() {
        if (top == 0)
            return true;
        else
            return false;
    }
}