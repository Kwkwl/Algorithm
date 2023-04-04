

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken());
		long w = Long.parseLong(stk.nextToken());

		ArrayList<Integer>[] tree = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			stk = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());

			tree[u].add(v);
			tree[v].add(u);
		}

		int leafNodeCnt = 0;
		for (int i = 2; i < n + 1; i++) {
			if (tree[i].size() == 1) {
				leafNodeCnt++;
			}
		}
		System.out.println(String.format("%.10f", (double) w / leafNodeCnt));
	}

}
