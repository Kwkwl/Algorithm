
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		Deque<int[]> d = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		int idx = 1;

		while (stk.hasMoreTokens()) {
			d.offer(new int[] { idx++, Integer.parseInt(stk.nextToken()) });
		}

		int[] nums = d.pollFirst();
		sb.append(nums[0] + " ");
		int num = nums[1];

		while (n-- > 1) {
			if (num > 0) {
				for (int i = 0; i < num - 1; i++) {
					d.offer(d.pollFirst());
				}
				nums = d.pollFirst();
				sb.append(nums[0] + " ");
				num = nums[1];
			} else {
				num = Math.abs(num);
				for (int i = 0; i < num - 1; i++) {
					d.offerFirst(d.pollLast());
				}
				nums = d.pollLast();
				sb.append(nums[0] + " ");
				num = nums[1];
			}
		}
		System.out.println(sb.toString().trim());
	}
}
