
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c, n;
	static char[][] grid;
	static int[][] bombtime;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		// 세로
		r = Integer.parseInt(stk.nextToken());
		// 가로
		c = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());

		grid = new char[r][c];
		bombtime = new int[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();

			for (int j = 0; j < c; j++) {
				grid[i][j] = str.charAt(j);

				if (grid[i][j] == 'O') {
					bombtime[i][j] = 3;
				}
			}
		}

		bomb();

		for (int i = 0; i < r; i++) {
			System.out.println(grid[i]);
		}

	}

	private static void bomb() {
		int time = 0;

		while (time++ < n) {
			// 폭탄 설치
			if (time % 2 == 0) {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (grid[i][j] == '.') {
							grid[i][j] = 'O';
							bombtime[i][j] = time + 3;
						}
					}
				}
			} else {
				// 폭발 시간이 된 폭탄 터짐
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (bombtime[i][j] == time) {
							grid[i][j] = '.';

							for (int k = 0; k < 4; k++) {
								int nextX = i + dx[k];
								int nextY = j + dy[k];

								if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c)
									continue;

								if (grid[nextX][nextY] == 'O' && bombtime[nextX][nextY] != time) {
									grid[nextX][nextY] = '.';
									bombtime[nextX][nextY] = 0;
								}
							}
						}
					}
				}
			}
		}
	}
}
