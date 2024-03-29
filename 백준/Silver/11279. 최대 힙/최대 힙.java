
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if (x != 0) {
				pq.offer(x);
			} else {
				if (pq.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
