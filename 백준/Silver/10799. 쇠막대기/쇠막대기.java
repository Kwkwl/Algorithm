
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		String bars = br.readLine();

		int result = 0;

		for (int i = 0; i < bars.length(); i++) {
			char bar = bars.charAt(i);
			if (bar == '(') {
				stack.push(bar);
			} else {
				if (bars.charAt(i - 1) == '(') {
					// 레이저
					stack.pop();
					// 레이저를 제외한 막대기 개수만 더해야 하기 때문에 먼저 pop을 해야 함
					result += stack.size();
				} else {
					// 막대기 끝
					result++;
					stack.pop();
				}
			}
		}
		System.out.println(result);
		br.close();
	}
}
