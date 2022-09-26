import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=10; tc++) {
			int N = sc.nextInt();
			String pw = sc.next();
			Stack<Character> s = new Stack<>();
			for(char c : pw.toCharArray()) {
				if(s.isEmpty() || s.peek() != c) {
					s.push(c);
				}else {
					s.pop();
				}
			}
			while(!s.isEmpty()) {
				sb.append(s.pop());
			}
			System.out.println("#"+tc+" "+sb.reverse());
			sb.delete(0, sb.length());
		}
		sc.close();
	}
}
