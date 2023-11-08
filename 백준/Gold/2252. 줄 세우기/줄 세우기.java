import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		//학생의 수
		int N = Integer.parseInt(st.nextToken());
		//키를 비교한 횟수
		int M = Integer.parseInt(st.nextToken());
		//내 앞에 있는사람 체크해주기 위해 넣어주기.
		int student[] = new int[N+1];
		List<Integer> li [] = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			li[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			//학생 A가 B 앞에 서야한다. 즉 B에 1 추가.
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			student[B]++;
			//그러고 A의 뒤에 B가 있다는 것을 알려주기.(A의 뒤에있는 애들 전부 1씩감소)
			li[A].add(B);
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(student[i] == 0) {
				q.add(i);
			}
		}
		//큐에 담긴 것이 다 빌때까지 빼주기.
		while(!q.isEmpty()) {
			//먼저 큐에 저장된 숫자는 더이상 앞에 사람이 없다는 것이니 빼주고
			int num = q.poll();
			//StrigBuilder에 저장해서 넣어주기.
			sb.append(num).append(" ");
			//그리고 해당 List의 번호에서 뒤에 있던 번호들 하나씩 빼주기.
			for(int i : li[num]) {
				student[i]--;
				//만약 0이되었다면 내가 가장 앞으로 간 것이니?
				if(student[i] == 0) {
					//큐에 담아주기.
					q.add(i);
				}
			}
		}
		System.out.println(sb);
	}
}