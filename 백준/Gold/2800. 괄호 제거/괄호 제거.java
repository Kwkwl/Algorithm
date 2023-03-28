
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;

public class Main {

	static boolean[] visited;
	static ArrayList<int[]> list = new ArrayList<>();
	static TreeSet<String> set = new TreeSet<>();
	static boolean isFirst = true;
	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case '(':
				stack.push(i);
				break;
			case ')':
				list.add(new int[] { stack.pop(), i });
				break;
			}

		}
		visited = new boolean[str.length()];
		Arrays.fill(visited, true);
		printBrackets(0);

		for(String s : set) {
			sb.append(s+"\n");
		}
		System.out.println(sb);
		br.close();
	}

	public static void printBrackets(int depth) {
		if (depth == list.size()) {
			if (isFirst) {
				isFirst = false;
			} else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < str.length(); i++) {
					if (visited[i]) {
						sb.append(str.charAt(i));
					}
				}
				set.add(sb.toString());
			}
			return;
		}

		int[] bracket = list.get(depth);
		visited[bracket[0]] = true;
		visited[bracket[1]] = true;

		printBrackets(depth + 1);

		visited[bracket[0]] = false;
		visited[bracket[1]] = false;

		printBrackets(depth + 1);

	}
}
