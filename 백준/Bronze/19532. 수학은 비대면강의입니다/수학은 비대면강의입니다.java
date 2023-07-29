
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 #19532 연립방정식
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
		while (stk.hasMoreElements()) {
			a = Integer.parseInt(stk.nextToken());
			b = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			d = Integer.parseInt(stk.nextToken());
			e = Integer.parseInt(stk.nextToken());
			f = Integer.parseInt(stk.nextToken());
		}

		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if (a * x + b * y == c && d * x + e * y == f) {
					System.out.println(x + " " + y);
				}
			}
		}
	}
}
