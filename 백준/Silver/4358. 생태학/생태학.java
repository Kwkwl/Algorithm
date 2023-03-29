
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int totalCnt = 0;

		while (true) {
			String tree = br.readLine();
			if (tree == null || tree.length() == 0) {
				break;
			}

			map.put(tree, map.getOrDefault(tree, 0) + 1);
			totalCnt++;
		}

		Object[] trees = map.keySet().toArray();
		Arrays.sort(trees);

		for (Object tree : trees) {
			String key = (String) tree;
			int cnt = map.get(key);
			double percent = (double) cnt / totalCnt * 100;
			sb.append(key + " " + String.format("%.4f", percent) + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
