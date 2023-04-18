
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int m;
	static int n;
	static int[][] field;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 개수
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

			// 가로
			m = Integer.parseInt(stk.nextToken());
			// 세로
			n = Integer.parseInt(stk.nextToken());
			// 배추가 심어져 있는 위치의 개수
			int k = Integer.parseInt(stk.nextToken());

			field = new int[m][n];
			visited = new boolean[m][n];

			for (int i = 0; i < k; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());

				field[x][y] = 1;
			}

			int earthworm = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && field[i][j] == 1) {
						bfs(i, j);
						earthworm++;
					}
				}
			}
			System.out.println(earthworm);
		}
	}

	private static void bfs(int x, int y) {
		LinkedList<int[]> q = new LinkedList<>();

		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] position = q.poll();
			int nowX = position[0];
			int nowY = position[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX >= m || nextY >= n || nextX < 0 || nextY < 0)
					continue;
				if (visited[nextX][nextY] || field[nextX][nextY] == 0)
					continue;

				q.add(new int[] { nextX, nextY });
				visited[nextX][nextY] = true;
			}

		}
	}
}
