import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			String s = sc.next();
			Stack<Character> s1 = new Stack<>(); // ( 에 대한 스택
			Stack<Character> s2 = new Stack<>(); // ( 에 대한 스택
			Stack<Character> s3 = new Stack<>(); // ( 에 대한 스택
			Stack<Character> s4 = new Stack<>(); // ( 에 대한 스택
			for(int i = 0; i<N; i++) {
				switch(s.charAt(i)) {
				case '(':
					s1.add(s.charAt(i));
					break;
				case ')':
					if(!s1.isEmpty()) {
						if(s1.peek()=='(') {
							s1.pop();
						}else {
							s1.add(s.charAt(i));
						}		
					}else {
						s1.add(s.charAt(i));
					}
					break;
				case '[':
					s2.add(s.charAt(i));
					break;
				case ']':
					if(!s2.isEmpty()) {
						if(s2.peek()=='[') {
							s2.pop();
						}else {
							s2.add(s.charAt(i));
						}
					}else {
						s2.add(s.charAt(i));
					}
					break;
				case '{':
					s3.add(s.charAt(i));
					break;
				case '}':
					if(!s3.isEmpty()) {
						if(s3.peek()=='{') {
							s3.pop();
						}else {
							s3.add(s.charAt(i));
						}
					}else {
						s3.add(s.charAt(i));
					}
					break;
				case '<':
					s4.add(s.charAt(i));
					break;
				case '>':
					if(!s4.isEmpty()) {
						if(s4.peek()=='<') {
							s4.pop();
						}else {
							s4.add(s.charAt(i));
						}			
					}else {
						s4.add(s.charAt(i));
					}
					break;
				}
			}
			int ans;
			int result = (s1.size() + s2.size() + s3.size() + s4.size());
			if(result == 0 ) {
				ans = 1;
			}else {
				ans = 0;
			}
			sb.append(ans);
			if(tc!=10)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}