
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
        // n: 전체 탑의 개수
		int n = Integer.parseInt(br.readLine());
        // int[]의 첫 번째 요소: 해당 탑의 위치, int[]의 두 번째 요소: 해당 탑의 높이
		Stack<int[]> stack = new Stack<>();

		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			int nowTopHeight = Integer.parseInt(stk.nextToken());
            
			while (!stack.isEmpty()) {
                // stack의 마지막 요소(탑)의 높이가 현재 탑의 높이보다 크거나 같은 경우, 수신할 수 있는 탑이 생김
				if (stack.peek()[1] >= nowTopHeight) {
					sb.append(stack.peek()[0]+" ");
					break;
				}
                // 현재 직전의 탑의 높이가 현재 탑의 높이보다 낮은 경우 stack에서 제거
				stack.pop();
			}
            // stack이 빈 경우 -> 첫 번째 탑에서 수신할 탑을 찾는 경우 or 현재 직전의 탑의 높이가 현재 탑의 높이보다 낮아, 수신할 탑이 없는 경우 
			if (stack.isEmpty()) {
				sb.append("0 ");
			}
            // 현재 탑의 위치 및 높이를 stack에 저장
			stack.push(new int[] {i, nowTopHeight});
		}

		System.out.println(sb.toString());
	}
}
