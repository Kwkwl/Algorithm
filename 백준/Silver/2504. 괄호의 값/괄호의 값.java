
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 1.'(', '['일 경우, stack에 해당 괄호를 넣고 val에 ('('일 경우) 2를, ('['일 경우) 3을 곱함.
// 2. ')', ']'일 경우, stack이 비어있거나, stack의 마지막 요소가 (')'일 경우) '(', (']'일 경우) '['가 아닐 경우, 
//  total 값을 0으로 변경 후 반복문 종료.
// 2-1. 전체 문자열 중 이전 인덱스의 값이 (')'일 경우) '(', (']'일 경우) '['이면  val 값을 total에 더함.
// 2-2. stack에서 pop. (올바른 괄호열에 대한 계산이 끝났기 때문에 stack에서 pop해야 함 + val 값 또한 2 또는 3으로 나눠야 함)
// 3. 반복문 종료 후 stack이 비어있지 않으면 0 출력(잘못된 괄호열이기 때문), 그렇지 않으면 total 값 출력.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String brackets = br.readLine();
		Stack<Character> stack = new Stack<>();

		int total = 0;
		int val = 1;

		exit: for (int i = 0; i < brackets.length(); i++) {
			char bracket = brackets.charAt(i);

			switch (bracket) {
			case '(':
				val *= 2;
				stack.push(bracket);
				break;
			case '[':
				val *= 3;
				stack.push(bracket);
				break;
			case ')':
				if (stack.isEmpty() || stack.peek() != '(') {
					total = 0;
					break exit;
				} else if (brackets.charAt(i - 1) == '(') {
					total += val;
				}
				stack.pop();
				val /= 2;
				break;
			case ']':
				if (stack.isEmpty() || stack.peek() != '[') {
					total = 0;
					break exit;
				} else if (brackets.charAt(i - 1) == '[') {
					total += val;
				}
				stack.pop();
				val /= 3;
				break;
			}

		}
		if (!stack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(total);
		}
	}
}
