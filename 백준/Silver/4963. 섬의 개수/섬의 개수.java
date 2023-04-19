
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1 ,1, -1, 1, -1, 1};
	static int[] dy = {-1, 1, 0, 0, 1, 1, -1, -1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

			w = Integer.parseInt(stk.nextToken());
			h = Integer.parseInt(stk.nextToken());

			if (w == 0 && h == 0) {
				System.out.println(sb);
				break;
			}

			map = new int[w][h];
			visited = new boolean[w][h];

			for (int i = 0; i < h; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[j][i] = Integer.parseInt(stk.nextToken());
				}
			}

			int island = 0;
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						island++;
					}
				}
			}
			sb.append(island + "\n");
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

			for (int i = 0; i < 8; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX >= w || nextY >= h || nextX < 0 || nextY < 0)
					continue;
				if (visited[nextX][nextY] || map[nextX][nextY] == 0)
					continue;

				q.add(new int[] { nextX, nextY });
				visited[nextX][nextY] = true;
			}
		}
	}
}
