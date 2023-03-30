
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int m = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder();
			PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Integer> minPQ = new PriorityQueue<>();

			int cnt = 0;
			for (int i = 0; i < m; i++) {
				if (i % 10 == 0) {
					stk = new StringTokenizer(br.readLine());
				}

				int num = Integer.parseInt(stk.nextToken());
				
				if (maxPQ.size() == minPQ.size()) {
					maxPQ.offer(num);
				} else {
					minPQ.offer(num);
				}

				if (!minPQ.isEmpty()) {
					if (maxPQ.peek() > minPQ.peek()) {
						maxPQ.offer(minPQ.poll());
						minPQ.offer(maxPQ.poll());
					}
				}

				if (i % 2 == 0) {
					sb.append(maxPQ.peek() + " ");
					cnt++;

					if (cnt == 10) {
						sb.append("\n");
					}
				}
			}
			System.out.println(cnt);
			System.out.println(sb);
		}
		br.close();
	}
}
