import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dp[] = new int[K+1];
		for(int i = A; i <= K; i++) {
			//만들수 없는애들 먼저 거르기.
			if(i != A && dp[i] == 0) {
				dp[i] = -1;
				continue;
			}
			if(i + 1 <= K) {
				dp[i+1] = (dp[i+1] == 0) ? dp[i] + 1 : Math.min(dp[i+1], dp[i] + 1);
			}
			if(i * 2 <= K) {
				dp[i*2] = dp[i*2] == 0 ? dp[i] + 1 : Math.min(dp[i*2], dp[i] + 1);
			}
		}
		System.out.println(dp[K]);
	}
}