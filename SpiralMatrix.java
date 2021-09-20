import java.util.Scanner;

public class SpiralMatrix {

	static int cnt = 0;

	static void printRight(int[][] mat, int c, int C, int R) {

		for (int i = c; i <= C; i++) {
			cnt++;
			System.out.print(mat[R][i] + " ");
		}
	}

	static void printLeft(int[][] mat, int c, int C, int R) {

		for (int i = C; i >= c; i--) {
			cnt++;
			System.out.print(mat[R][i] + " ");
		}
	}

	static void printUp(int[][] mat, int r, int R, int C) {

		for (int i = R; i >= r; i--) {
			cnt++;
			System.out.print(mat[i][C] + " ");
		}
	}

	static void printDown(int[][] mat, int r, int R, int C) {

		for (int i = r; i <= R; i++) {
			cnt++;
			System.out.print(mat[i][C] + " ");
		}
	}

	public static void main(String[] args) {

		int R = 4, C = 4;
		int CC = C - 1;
		int RR = R - 1;

		int[][] mat = new int[R][C];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				mat[i][j] = sc.nextInt();
				System.out.print(mat[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println();
		int left = 0;
		int right = RR;
		int top = 0;
		int button = CC;
		while (cnt <= R * C) {

			printRight(mat, left, right, left);
			top++;
			printDown(mat, top, button, right);
			right--;
			if (button < top)
				break;
			printLeft(mat, left, right, button);
			button--;
			if (right < left)
				break;
			printUp(mat, top, button, left);
			left++;
		}

	}

}
