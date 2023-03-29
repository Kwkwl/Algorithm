
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}

		});

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			int problemNum = Integer.parseInt(stk.nextToken());
			int level = Integer.parseInt(stk.nextToken());
			map.put(problemNum, level);
			set.add(new int[] { problemNum, level });

		}

		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			String command = stk.nextToken();

			switch (command) {
			case "add":
				int problemNum = Integer.parseInt(stk.nextToken());
				int level = Integer.parseInt(stk.nextToken());

				map.put(problemNum, level);
				set.add(new int[] { problemNum, level });

				break;
			case "recommend":
				int num = Integer.parseInt(stk.nextToken());

				if (num == 1) {
					sb.append(set.last()[0] + "\n");
				} else {
					sb.append(set.first()[0] + "\n");
				}
				break;
			case "solved":
				problemNum = Integer.parseInt(stk.nextToken());
				set.remove(new int[] {problemNum, map.get(problemNum)});
				break;
			}
		}
		System.out.println(sb);
		br.close();
	}
}
