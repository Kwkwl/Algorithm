
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Integer[] moneys = new Integer[n];

		for (int i = 0; i < n; i++) {
			moneys[i] = Integer.valueOf(br.readLine());
		}

		Arrays.sort(moneys, Comparator.reverseOrder());

		long totalTip = 0;
		for (int i = 0; i < n; i++) {
			int tip = moneys[i] - i;

			if (tip <= 0)
				break;

			totalTip += tip;
		}

		System.out.println(totalTip);
		br.close();

	}
}
