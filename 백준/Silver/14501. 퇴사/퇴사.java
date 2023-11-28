import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//남은 일
		int N = Integer.parseInt(br.readLine());
		//걸리는 기간과 받을 수 있는 금액.
		int TP[][] = new int[N][2];
		int dp[] = new int[N+1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			//기간.
			TP[i][0] = Integer.parseInt(st.nextToken());
			//금액.
			TP[i][1] = Integer.parseInt(st.nextToken());			
		}
		for(int i = N-1; i >= 0; i--) {
			//일할 수 있는 기간 내라면?
			if(i + TP[i][0] <= N) {
				//비교를 해주어야 함.
				dp[i] = Math.max(dp[i + TP[i][0]] + TP[i][1], dp[i+1]);
			//일을 할 수 없는 기간이라면?
			}else {
				//그냥 이전에 있는 시간을 넣어주자.
				dp[i] = dp[i+1];
			}
		}
		//dp의 맨 처음에 있는 값이 가장 최대 수익.
		System.out.println(dp[0]);
	}
}