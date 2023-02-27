package Chap4_스택과큐;

import java.util.Random;
import java.util.Scanner;

class Point_2 {
	private int ix;
	private int iy;
	
	public Point_2(int x, int y) {
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
public class 원형큐_test {

	public static void main(String[] args) {
		try(Scanner stdIn = new Scanner(System.in)) {
		원형큐 s = new 원형큐(4); // 최대 4개를 push할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point_2 p = null;
		
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.print("(1)push　(2)pop　(3)clear (4)print");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point_2(rndx,rndy);
				try {
					s.push(p);
					System.out.println("push한 데이터는 " + p + "입니다.");
				} catch(원형큐.Overflow원형큐Exception e) {
					System.out.println("원형큐가 가득 찼습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = s.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch(원형큐.Empty원형큐Exception e) {
					System.out.println("원형큐가 비어있습니다.");
				}
				break;

			case 3: // 클리어
				s.clear();
				break;
			case 4: // 프린트
				s.print(); 
				break;
			default: continue;
			}
		}
		}
	}
}