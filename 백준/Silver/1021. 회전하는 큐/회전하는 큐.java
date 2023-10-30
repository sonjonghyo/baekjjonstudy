import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int num[] = new int[M];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		//LinkedList를 사용하여 찾아야할 번호를 빠르게 찾자.
		LinkedList<Integer> li = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			li.add(i);
		}
		for(int i = 0; i < M; i++) {
			//내가 찾아야 할 위치 찾기.
			int idx = li.indexOf(num[i]);
			//중간 지점을 찾아서 중간지점보다 왼쪽이면 3번 오른쪽이면 2번 사용하게함.
			int middle = 0;				
			if(li.size() % 2 == 0) {
				middle = li.size() / 2 - 1;
			}else {
				middle = li.size() / 2;
			}
			//중간 지점보다 작거나 같다면?
			if(idx <= middle) {
				//2번 실행.(왼쪽으로 이동)
				for(int j = 0; j < idx; j++) {
					//맨앞
					int tmp = li.pollFirst();
					li.offerLast(tmp);
					result++;
				}
			//중간 지점보다 크다면? 오른쪽으로 이동.
			}else {
				//3번 실행.
				for(int j = 0; j < li.size() - idx; j++) {
					int tmp = li.pollLast();
					li.offerFirst(tmp);
					result++;
				}
			}
			//그러고서 맨앞 원소 삭제.
			li.poll();
		}
		System.out.println(result);
	}
}