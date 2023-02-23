package Chap6_정렬알고리즘;

import java.util.Arrays;

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


public class QuickSort_Stack<T> {
    private T[] stack;
    private int top;
    
    @SuppressWarnings("unchecked")
    public QuickSort_Stack(int capacity) {
        stack = (T[]) new Object[capacity];
        top = -1;
    }
    
    public void push(T item) {
        if (top == stack.length - 1) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
        top++;
        stack[top] = item;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("스택이 비었습니다.");
        }
        T item = stack[top];
        top--;
        return item;
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("스택이 비었습니다.");
        }
        return stack[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
}