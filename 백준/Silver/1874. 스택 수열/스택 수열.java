import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 개수
		int num[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		int location = 0; //현재 배열의 위치를 나타내줄 변수입니다.
		for(int i = 1; i <= n; i++) {
			stack.add(i);
			sb.append('+').append("\n");
			while(!stack.isEmpty() && stack.peek() == num[location]) { //스택의 맨위 값과 현재 배열의 위치 값이 같다면?
				stack.pop(); //스택의 맨 위 값을 빼주자
				location++; //그러고 배열의 위치값 추기
				sb.append('-').append("\n");
			}
		}
		if(stack.isEmpty()) { //만약 스택이 비어있다면?(다 비웠으니까 sb출력)
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}
}