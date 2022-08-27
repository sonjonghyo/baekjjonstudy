import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack<Character> st1; // 원래 (와 )를 만났을때 담아줄 stack
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		while (true) { // 여러줄의 문자열을 입력받기 위해 사용.
			s = br.readLine(); // 문자열을 받고
			if (s.equals(".")) { // 만약 문자열에 .이찍힌다면
				break; // while문을 끝내준다.
			}
			balance(s); // 균형잡기위해 함수로 이동.
			sb.append("\n"); // 끝나고 개행문자를 추가해준다.
		}
		System.out.println(sb);

	}

	static void balance(String s) {
		st1 = new Stack<>();
		for (int i = 0; i < s.length(); i++) { // 문자열의 길이만큼 for문을 사용해주며
			// '(' 나 '[' 는 상관없이 무조건 추가가된다.
			// 하지만 ')', ']'는 혼자 올수 없으므로 사이즈가 0일때 얘네들이 들어온다면 무조건 no가 출력될것이고
			// )앞에 (가 ] 앞에 (가 없으면 균형잡히지 않은 것이므로 바로 no를 출력해주고 함수를 끝내준다.
			// 처음에는 ([)]를 생각했는데 이런건 이 문제에서 올수가 없다.
			if (s.charAt(i) == '(') {
				st1.push('(');
			} else if (s.charAt(i) == ')') {
				if (st1.size() == 0 || st1.peek() != '(') {
					sb.append("no");
					return;
				} else {
					st1.pop();
				}
			} else if (s.charAt(i) == '[') {
				st1.push('[');
			} else if (s.charAt(i) == ']') {
				if (st1.size() == 0 || st1.peek() != '[') {
					sb.append("no");
					return;
				} else {
					st1.pop();
				}

			} else if (i == s.length() - 1 && s.charAt(i) == '.') { // 문자열 끝.
				if (st1.size() == 0) {
					sb.append("yes"); // 스택이 전부 비워져있다면 균형잡힌 문장이므로 yes를 추가해준다.
				} else {
					sb.append("no"); // 혹시라도 스택에 (나 [가 남겨져있다면 사이즈가 있다는 것. 균형잡히지않았으므로 no를 추가해준다.
				}
			}
		}
	}
}