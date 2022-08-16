import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int top = -1;
	static Stack<Character> op = new Stack<>();
	static String answer = "";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		for (int i = 0; i < s.length(); i++) {
			compare(s.charAt(i), i);
		}
		System.out.print(answer); //출력 부분 수정필요함.
		for(int i = op.size()-1; i>=0; i--) {
			System.out.print(op.get(i));
		}
	}

	public static void compare(char a, int i) {
		if (a == '*' || a == '/' || a == '+' || a == '-' || a == '(' || a == ')') {
			if (a == '(') { // 왼쪽괄호는 무조건 추가가 됌.
				op.push(a);
				++top;
			} else if (a == '+') {
				if (op.size() == 0) { // 만약 현재 stack에 아무것도 없다면 바로 스택에 쌓기.
					op.push(a);
					++top;
				} else { // 전의 연산자를 비교하여 나보다 연산순위가 낮으면 쌓고, 높거나 같으면 빼고(pop) 넣기(push)
					while (op.get(top) == '+' || op.get(top) == '-' || op.get(top) == '*'|| op.get(top) == '/') { // op의 바로 전 값을 가져와야함.
						answer += op.pop();
						top--;
						if (op.size() == 0) {
							break;
						}
					}
					op.push(a);
					++top;
				}
			} else if (a == '-') {
				if (op.size() == 0) { // 만약 현재 stack에 아무것도 없다면 바로 스택에 쌓기.
					op.push(a);
					++top;
				} else { // 전의 연산자를 비교하여 나보다 연산순위가 낮으면 쌓고, 높거나 같으면 빼고(pop) 넣기(push)
					while (op.get(top) == '+' || op.get(top) == '-' || op.get(top) == '*' || op.get(top) == '/') {
						answer += op.pop();
						top--;
						if (op.size() == 0) {
							break;
						}
					}
				}
				op.push(a);
				++top;
			} else if (a == '*') {
				if (op.size() == 0) { // 만약 현재 stack에 아무것도 없다면 바로 스택에 쌓기.
					op.push(a);
					++top;
				} else { // 전의 연산자를 비교하여 나보다 연산순위가 낮으면 쌓고, 높거나 같으면 빼고(pop) 넣기(push)
					while (op.get(top) == '*' || op.get(top) == '/') {
						answer += op.pop();
						top--;
						if (op.size() == 0) {
							break;
						}
					}
					op.push(a);
					++top;
				}
			} else if (a == '/') {
				if (op.size() == 0) { // 만약 현재 stack에 아무것도 없다면 바로 스택에 쌓기.
					op.push(a);
					++top;
				} else { // 전의 연산자를 비교하여 나보다 연산순위가 낮으면 쌓고, 높거나 같으면 빼고(pop) 넣기(push)
					while (op.get(top) == '*' || op.get(top) == '/' && op.size() != 0) {
						answer += op.pop();
						top--;
						if (op.size() == 0) {
							break;
						}
					}
					op.push(a);
					++top;
				}
			} else if (a == ')') { // (를 만날때까지 pop을 해줌.
				while (true) {
					if(op.get(top) == '('){
						op.pop();
						top--;
						break;
					}else {
						answer += op.pop();
						top--;
					}
				}
			}
		} else {
			answer += a; // 피연산자일시에 바로 출력.(굳이 num에 넣을 필요가있을까?..)
		}
		// 다 끝나고 피연산자, 연산자 전부 뽑아내야함.
	}
}