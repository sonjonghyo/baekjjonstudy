import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		//사용한 알파벳인지 아닌지 확인.
		boolean alpha[] = new boolean[26];
		LinkedList<String> li = new LinkedList<>();
		//처음에 전부 물음표로 시작.
		for(int i = 0; i < N; i++) {
			li.add("?");
		}
		//만들수 있는지 없는지 결정해주는 변수.
		boolean flag = true;
		//K번 진행.
		loop : for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int change = Integer.parseInt(st.nextToken());
			String word = st.nextToken();
			//회전시키기.
			for(int j = 0; j < change; j++) {
				//회전시키면서 맨 마지막에 있는것이 맨앞으로 이동시켜주기.
				li.addFirst(li.pollLast());
			}
			//조건 1. 들어갈 순 있지만 이미 나온글자인데 화살표가 아닌 곳에서 또 나온다면 !
			//조건 2. 화살표가 도착한곳에 이미 글자가 들어가 있는데 다른 글자가 들어가려한다면 !
			if(li.peek().equals("?") && alpha[word.charAt(0) - 'A'] ||  !li.peek().equals("?") && !li.peek().equals(word)) {
				//못만드니까 false로 만든후 끝내기.
				flag = false;
				break loop;
			//넣을 수 있으니 넣어줌.
			}else {
				//맨 처음거 빼주고 그자리에 word를 넣어주고 사용한 알파벳이니 알파벳 배열에서 true로 변경.
				li.pollFirst();
				li.addFirst(word);
				alpha[word.charAt(0) - 'A'] = true;
			}
		}
		//행운의 돌림판 출력.
		if(flag) {
			for(int i = 0; i < N; i++) {
				System.out.print(li.pollFirst());
			}
		//못만드니 느낌표 출력
		}else {
			System.out.println("!");
		}
	}
}