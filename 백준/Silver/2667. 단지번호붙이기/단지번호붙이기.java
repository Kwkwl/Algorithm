
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int n;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] dx = { -1, 1, 0, 0 }; // 상하
	static int[] dy = { 0, 0, -1, 1 }; // 좌우

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int complexCnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					complexCnt++;
				}
			}
		}
		System.out.println(complexCnt);

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void bfs(int x, int y) {
		LinkedList<int[]> q = new LinkedList<>();
		int totalHouseCnt = 1;

		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] position = q.poll();
			int nowX = position[0];
			int nowY = position[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX >= n || nextY >= n || nextX < 0 || nextY < 0)
					continue;
				if (visited[nextX][nextY] || map[nextX][nextY] == 0)
					continue;

				q.add(new int[] { nextX, nextY });
				visited[nextX][nextY] = true;
				totalHouseCnt++;
			}
		}
		list.add(totalHouseCnt);
	}
}
