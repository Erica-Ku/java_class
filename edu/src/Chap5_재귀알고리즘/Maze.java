package Chap5_재귀알고리즘;

public class Maze {
	
	class offsets {
		int a, b;
	}

	static class items {
		int x;
		int y;
		int dir;
	}
	
	enum direction {
		N, n, E, e, S, s, W, w
	}
	
	static offsets moves[] = new offsets [8];
	static int maze[][] = new int [100][100];
	static int mark[][] = new int [100][100];
	static int N;
	
	static void path(int m, int p) {
		mark[1][1] = 1;
		MazeStack ms = new MazeStack(m*p);
		items items = new items();
		int temp;
		
		items.x = 1;
		items.y = 1;
		items.dir = 2;
		
		ms.push(items.x);
		ms.push(items.y);
		ms.push(items.dir);
		
		while(!ms.isEmpty()) {
			temp = ms.pop();
			int i = items.x; int j = items.y; int d = items.dir;
			while(d<8) {
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				if ((g == m) && (h == p)) {
					System.out.println(ms);
					System.out.println("the term near the exit: " + i + " " + j );
					System.out.println("exit: " + m + " " + p);
					return;
				}
				if (maze[i][j]!=maze[g][h]) 
					if(mark[i][j]!=mark[g][h]) {
						mark[g][h] = 1;
						items.x = i;  items.y = j; items.dir = d + 1;
						ms.push(items.x);
						ms.push(items.y);
						ms.push(items.dir);
						i = g; j = h; d = N;
				}
				else d++;
			}
		}
		System.out.println("no path in maze ");
	}
	
	public static void main(String[] args) {
		int input[][] = {{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
						{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
						{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
						{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
						{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
						{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
						{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
						{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
						{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
						{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
						{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
						{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		moves[0].a = -1; moves[0].b = 0;
		moves[1].a = -1; moves[1].b = 1;
		moves[2].a = 0; moves[2].b = 1;
		moves[3].a = 1; moves[3].b = 1;
		moves[4].a = 1; moves[4].b = 0;
		moves[5].a = 1; moves[5].b = -1;
		moves[6].a = 0; moves[6].b = -1;
		moves[7].a = -1; moves[7].b = -1;
		
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++)
			{
				if ((i!=i) || (j!=j) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				};
				mark[i][j] = 0;

			}
		}
		for (int i = 0; i <= 13; i++)
		{
			for (int j = 0; j <= 16; j++)
				System.out.println(maze[i][j] + " "); 
			System.out.println();
		}
		path(12, 15);
	}
}
