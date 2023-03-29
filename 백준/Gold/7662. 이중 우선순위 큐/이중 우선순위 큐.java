
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<>();
			while (k-- > 0) {
				StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
				String command = stk.nextToken();

				switch (command) {
				case "I":
					int num = Integer.parseInt(stk.nextToken());
					map.put(num, map.getOrDefault(num, 0) + 1);
					break;
				case "D":
					if (map.isEmpty())
						break;

					num = Integer.parseInt(stk.nextToken());
					// num == 1 -> 최댓값 제거, num == -1 -> 최솟값 제거
					int key = num == 1 ? map.lastKey() : map.firstKey();
					// map.put(key, map.get(key) - 1): 해당 key의 이전(put 하기 전) 값 반환 
					if (map.put(key, map.get(key) - 1) == 1) {
						map.remove(key);
					}
					break;
				}
			}
			if (map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
	}
}
