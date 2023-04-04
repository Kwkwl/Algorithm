

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[] prime = new boolean[1000001];

		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int num = -1;
		while (num != 0) {
			num = Integer.parseInt(br.readLine());
			for (int i = 1; i <= num; i++) {
				if (!prime[num - i] && !prime[i]) {
					sb.append(num).append(" = ").append(i).append(" + ").append(num - i).append("\n");
					break;
				} else
					continue;
			}
		}
		if (sb.toString().equals("")) {
			System.out.println("Goldbach's conjecture is wrong.");
		} else
			System.out.println(sb);
	}
}
