import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			dp = new long[N+1][2];	
			if(N>0) {
				dp[0][0] = 1;
				dp[0][1] = 0;
				dp[1][0] = 0;
				dp[1][1] = 1;				
			} else {
				dp[0][0] = 1;
				dp[0][1] = 0;
			}
			fibo(N);
			sb.append(dp[N][0]).append(" ").append(dp[N][1]);
			if(i!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void fibo(int n) {
		for(int i = 2; i<=n; i++) {
			dp[i][0] = dp[i-2][0] + dp[i-1][0];
			dp[i][1] = dp[i-2][1] + dp[i-1][1];
		}
		
	}
}