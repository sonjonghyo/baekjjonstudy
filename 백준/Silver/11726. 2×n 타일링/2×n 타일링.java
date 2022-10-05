import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long result = pibo(N);
		System.out.println(result);
	}
	
	public static long pibo(int n) {
		dp = new long[n+1];
		dp[1] = 1;
		if(n>1) {
			dp[2] = 2;			
		}
		for(int i = 3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] = dp[i]%10007;
		}
		return dp[n];
	}
}