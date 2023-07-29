
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 #1816 비밀번호
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < cnt; i++) {
			Long pwd = Long.parseLong(br.readLine());

			for (int j = 2; j < 1_000_001; j++) {
				if (pwd < 1_000_000 || pwd % j == 0) {
					System.out.println("NO");
					break;
				}

				if (j == 1_000_000) {
					System.out.println("YES");					
				}
			}

		}

	}
}
