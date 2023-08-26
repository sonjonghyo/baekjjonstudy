import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		int value = 0; //현재 막대의 개수를 나타내는 변수입니다.
		int answer = 0; //총 개수
		String s = br.readLine();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				if(stack.isEmpty()) { //스택이 비어있었다면? => 아무것도 없었으니 그냥 추가.
					stack.add('('); 
					continue; 
				}
				if(stack.peek() == '(') { //이전 값이 '('인데 현재 값이 '('라면?
					stack.add('('); //일단 스택에 추가시켜주고
					value++; //길이 추가.
				}else { //이전 값이 ')'인데 현재 '('가 나왔다면?
					stack.add('('); //아무것도 없이 그냥 스택에 추가.
				}
			}else { //현재의 값이 ')'라면?
				if(stack.peek() == '(') { //이전의 값이 '('라면? 즉 레이저를 쏘는 구간이다.
					stack.add(')'); //추가 시켜주고
					answer += value; //자른 값을 추가시켜주자.
				}else { //이전의 값이 ')'인데 또 ')'가 나왔다면? 
					stack.add(')'); //stack에 담아 주고
					value--; //자를수 있는 쇠막대기 감소.
					answer++; //끊어지니까 하나 추가.
				}
			}
		}
		System.out.println(answer);
	}
}