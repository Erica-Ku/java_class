package Chap5_재귀알고리즘;

class Point4 {
	private int x;
	private int y;
	
	public Point4(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

class Stack {
	private int top;
	private Point4 [] data;
	
	public Stack() {
		top = 0;
		data = new Point4[100];
	}
	
	public void push(Point4 p) {
		data[top++] = p;
	}
	
	public Point4 pop() {
		return data[--top];
	}
	
	public boolean isEmpty() {
        if (top == 0)
            return true;
        else
            return false;
    }
}

public class EightQueen_1 {
	public static boolean checkMove(int x, int y, int[][] array) {
		if(!(checkRow(x,array))) return false;
		if(!(checkCol(y,array))) return false;
		if(!(checkDiagSW(x,y,array))) return false;
		if(!(checkDiagSE(x,y,array))) return false;
		return true;
	}
	
	public static boolean checkRow(int x, int[][] array) {
		for(int i=0;i<array[x].length;i++) {
			if(array[x][i]==1)
				return false;
		}
		return true;
	}
	
	public static boolean checkCol(int y, int[][] array) {
		for(int i=0;i<array[y].length;i++) {
			if(array[i][y]==1)
				return false;
		}
		return true;
	}
	
	public static boolean checkDiagSE(int x, int y, int[][] array) {
		int dx = x;
		int dy = y;
		while(dx>=0&&dx<array[y].length&&dy>=0&&dy<array[x].length) {
			if(array[dx][dy]==1)
				return false;
			dx++;
			dy--;
		}
		dx = x;
		dy = y;
		while(dx>=0&&dx<array[y].length&&dy>=0&&dy<array[x].length) {
			if(array[dx][dy]==1)
				return false;
			dx--;
			dy++;
		}
		return true;
	}
	
	public static boolean checkDiagSW(int x, int y, int[][] array) {
		int dx = x;
		int dy = y;
		while(dx>=0&&dx<array[y].length&&dy>=0&&dy<array[x].length) {
			if(array[dx][dy]==1)
				return false;
			dx++;
			dy++;
		}
		dx = x;
		dy = y;
		while(dx>=0&&dx<array[y].length&&dy>=0&&dy<array[x].length) {
			if(array[dx][dy]==1)
				return false;
			dx--;
			dy--;
		}
		return true;
	}
	
	public static void solveQueen(int row, int col, int[][] array) {
		Stack st = new Stack();
		Point4 p = new Point4(0,0);
		
		int x = p.getX();
		int y = p.getY();
		
		int flag = 0;
        while (true) {
            while (x < row) {
                while (y < col) {
                    if (checkMove(x, y, array)) {
                        array[x][y] = 1;
                        st.push(new Point4(x, y));
                        y = 0;
                        break;
                    }
                    y++;
                }
                x++;
                if (y >= col) {
                    if (!st.isEmpty()) {
                        p = st.pop();
                        x = p.getX();
                        y = p.getY();
                        array[x][y] = 0;
                        y++;
                    }
                    else{
                        flag = 1;
                        break;
                    }

                }
            }
            if (flag == 1) break;
            printBoard(row, col, array);
            p = st.pop();
            x = p.getX();
            y = p.getY();
            array[x][y] = 0;
            y++;
        }
    }
    static int num = 0;
    public static void printBoard(int row, int col, int[][] array) {

        System.out.println(++num);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
	}

	public static void main(String[] args) {
		int row = 8;
		int col = 8;
		int[][] array = new int[row][col];
		
		for(int i=0; i<array.length;i++) {
			for(int j=0; j<array[0].length; j++) {
				array[i][j] = 0;
			}
		}
		solveQueen(row, col, array);
		
	}
}