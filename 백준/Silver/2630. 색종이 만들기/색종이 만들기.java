
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] colorPaper;
	static int white;
	static int blue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		colorPaper = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				colorPaper[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		recur(0, 0, n);

		System.out.println(white);
		System.out.println(blue);
	}

	private static void recur(int x, int y, int size) {

		if (colorCheck(x, y, size)) {
			if (colorPaper[x][y] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}

		size = size / 2;

		recur(x, y, size);
		recur(x + size, y, size);
		recur(x, y + size, size);
		recur(x + size, y + size, size);
	}

	private static boolean colorCheck(int x, int y, int size) {

		int color = colorPaper[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (colorPaper[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
