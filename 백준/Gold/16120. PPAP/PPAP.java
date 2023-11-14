import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		//먼저 PPAP문자열 길이 만큼 문자열 돌려주기.
		for(int i = 0; i < s.length(); i++) {
			//먼저 stack에 넣어주고
			stack.add(s.charAt(i));
			//stack의 크기가 4보다 크다면 그때부터 비교 시작.
			if(stack.size() >= 4) {
				//cnt를 이용해 PPAP인지 확인.
				cnt = 0;
				//stack의 아래서 부터 PPAP가 완성이 되는지 체크하자.
				if(stack.get(stack.size()-1) == 'P') {
					cnt++;
				}
				if(stack.get(stack.size() - 2) == 'A') {
					cnt++;
				}
				if(stack.get(stack.size() - 3) == 'P') {
					cnt++;
				}
				if(stack.get(stack.size() - 4) == 'P') {
					cnt++;
				}
				//완성이 된다면 PPAP를 P로 변환시켜주자.
				if(cnt == 4) {
					stack.pop();
					stack.pop();
					stack.pop();
				}
			}
		}
		//for문이 끝나고 남아있는게 P인지 확인.(size가 1인것은 혹시 PAP같은 이상한 것들이 있을 수 있을까봐)
		if(stack.size() == 1 && stack.peek() == 'P') {
			System.out.println("PPAP");
		}else {
			System.out.println("NP");
		}
	}
}