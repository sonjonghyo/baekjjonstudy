import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int grade[] = new int[n+1];
		int speed[] = new int[n+1];
		int max = 0;
		for(int i = 1; i <= n; i++) { 
			st = new StringTokenizer(br.readLine());
			grade[i] = Integer.parseInt(st.nextToken());
			speed[i] = Integer.parseInt(st.nextToken());
			//가장 높은 우선순위를 찾기 위해 존재함.
			if(max < grade[i])
				max = grade[i];
		}
		List<Integer> list[] = new ArrayList[max+1];
		for(int i = 0; i <= max; i++) {
			list[i] = new ArrayList<>();
		}
		
		//list 담아주기.
		//1번은 1,7 이런식으로.
		//속도는 배열에 따로 넣어놓자.
		for(int i = 1; i <= n; i++) {
			list[grade[i]].add(i);
		}
		int dp[] = new int[n+1];
		for(int i : list[1]) {
			dp[i] = speed[i];
		}
		
		for(int i = 1; i < max; i++) {
			//다음 순서로 갈때 가장 많이 걸리는 시간 넣자.
			//다음 순서로 갈게
			for(int j : list[i+1]) {
				//현재 번호에서 갔을때 가장 많이 걸리는 시간 넣기.
				for(int k : list[i]) {
					dp[j] = Math.max(dp[j], dp[k] + (j-k) * (j-k));
				}
				//동작을 시작하기 위해선 컴퓨터 동작 속도만큼 필요하므로 속도 더해주기.
				//즉 다음에 시작할때 동작하기 위해서 + 해주는 것.
				dp[j] += speed[j];
			}
		}
		int answer = 0;
		for(int ans : list[max]) {
			answer = Math.max(answer, dp[ans]);
		}
		System.out.println(answer);
	}
}