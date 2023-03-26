
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

	    // 1. 피연산자는 바로바로 출력, 그 외의 연산자는 모두 stack에 저장
		// 2. stack에 넣기 전, 현재 연산자가 stack 마지막 요소보다 우선순위가 낮지 않을 때까지 pop
		// 3. 괄호의 경우, 현재의 요소가 ')'이면, '('가 나올 때까지 pop
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String infixNotation = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infixNotation.length(); i++) {
			char c = infixNotation.charAt(i);

			switch (c) {
			case '+':
			case '-':
			case '*':
			case '/':
				while (!stack.isEmpty()) {
					char storedC = stack.peek();
					if (storedC == '(' || storedC == ')') {
						break;
					} else {
						if (storedC == '+' || storedC == '-') {
							if (c == '*' || c == '/')
								break;
						}
						sb.append(stack.pop());
					}
				}
				stack.add(c);
				break;
			case '(':
				stack.add(c);
				break;
			case ')':
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				sb.append(c);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}
}
