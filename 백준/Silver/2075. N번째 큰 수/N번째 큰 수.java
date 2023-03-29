
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			while (stk.hasMoreTokens()) {
				pq.offer(Long.valueOf(stk.nextToken()));
			}

		}

		for (int i = 0; i < n - 1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
		
	}
}
