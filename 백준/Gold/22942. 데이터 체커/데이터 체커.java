
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> list = new ArrayList<>();

		// n: 원의 개수
		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			// x: 원의 중심 좌표
			int x = Integer.parseInt(stk.nextToken());
			// r: 원의 반지름
			int r = Integer.parseInt(stk.nextToken());
			list.add(new int[] { x, r });
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}

		});

		boolean check = false;
		int idx = 0;
		while (!list.isEmpty()) {
			int x = list.get(idx)[0];
			int r = list.get(idx)[1];
			int d = Math.abs(x - list.get(list.size() - 1)[0]);
			if (list.get(list.size() - 1)[1] + r < d || d < Math.abs(r - list.get(list.size() - 1)[1]) || d == 0) {
				list.remove(list.size() - 1);
			} else {
				check = true;
				System.out.println("NO");
				break;
			}
		}

		if (!check) {
			System.out.println("YES");
		}
	}
}
