
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// LCA: 주어진 두 노드 a, b의 최소 공통 조상 찾는 알고리즘
/*
 * 풀이방법
 * 1. 1번 루트노드를 기준으로 DFS 탐색을 하면서 각 노드의 트리 높이(height)와 부모 노드(parent)를 저장함
 * 2. LCA를 구하기 위한 a, b번 노드가 주어지면 해당 두 노드의 height를 동일하게 맞춤
 * 3. 높이가 맞춰졌으면 각 부모 노드가 일치할 때까지 비교해서 구함
 */
public class Main {

	static ArrayList<Integer>[] tree;
	static int[] parent, depth;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			parent = new int[n + 1];
			depth = new int[n + 1];
			tree = new ArrayList[n + 1];

			for (int i = 1; i < n + 1; i++) {
				tree[i] = new ArrayList<>();
			}

			// false일 경우, rootNode임을 의미함
			boolean[] checkChildNode = new boolean[n + 1];

			StringTokenizer stk;
			for (int i = 0; i < n - 1; i++) {
				stk = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());

				tree[a].add(b);
				checkChildNode[b] = true;
			}
			int rootIdx = 0;
			for (int i = 1; i < n + 1; i++) {
				if (!checkChildNode[i]) {
					rootIdx = i;
					break;
				}
			}

			init(rootIdx, 1, 0);

			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			System.out.println(LCA(a, b));
		}
	}

	static void init(int cur, int height, int pa) {
		depth[cur] = height;
		parent[cur] = pa;

		for (int next : tree[cur]) {
			if (next != pa) {
				init(next, height + 1, cur);
			}
		}
	}

	static int LCA(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];

		while (ah > bh) {
			a = parent[a];
			ah--;
		}

		while (bh > ah) {
			b = parent[b];
			bh--;
		}

		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		return a;
	}
}
