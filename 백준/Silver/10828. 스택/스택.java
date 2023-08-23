import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>(); //스택을 넣어주자.
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int num = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); //명령어를 넣어줄 부분입니다.
			String s = st.nextToken();
			if(s.equals("push")) { //만약 넣은 명령어가 push라면
				num = Integer.parseInt(st.nextToken()); //어떤 수인지 알아야하므로 num 변수에 저장해줍니다.
			}
			switch(s) { //switch문을 사용해 어떤 명령어 인지 확인하자.
			case "push": //정수 num을 stack에 넣어주는 연산
				stack.add(num);
				break;
			case "pop" : //만위의 정수를 빼고 수를 출력. 스택에 정수가 없으면 -1 출력.
				if(stack.isEmpty()) { //만약 stack이 비어있다면?
					sb.append(-1); //-1을 넣어주기
				}else { //그와 반대 상황이라면?
					sb.append(stack.pop()); //맨위 수를 넣어주기.
				}
				break;
			case "size" : //현재 stack의 size를 출력하기
				sb.append(stack.size());
				break;
			case "empty" : //stack이 비어있는지 확인
				if(stack.isEmpty()) { //비어있다면 1
					sb.append(1);
				}else { //아니면 0
					sb.append(0);
				}
				break;
			case "top" : //stack의 맨위 정수 출력
				if(stack.isEmpty()) { //비어있다면?
					sb.append(-1); //-1 출력
				}else { //스택안에 정수가 있다면
					sb.append(stack.peek()); //맨위 정수 출력
				}
				break;
				
			}
			if(i != N-1 && !s.equals("push")) //마지막을 제외하고는 개행문자 추가
				sb.append("\n");
		}
		System.out.println(sb);
	}
}