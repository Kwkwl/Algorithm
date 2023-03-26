
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		Deque<Integer> d = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());

		for (int i = 1; i <= n; i++) {
			d.offer(i);
		}

		sb.append("<");
		while (d.size() != 1) {
			for (int i = 0; i < k - 1; i++) {
				d.offer(d.pollFirst());
			}

			sb.append(d.poll() + ", ");

		}

		sb.append(d.poll() + ">");

		System.out.println(sb.toString());
	}
}
