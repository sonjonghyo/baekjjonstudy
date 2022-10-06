import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dp[][] = new int[N+1][K+1];
		int W[] = new int[N+1];
		int V[] = new int[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 0; j<=K; j++) {
				if(W[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
					
		}
		System.out.println(dp[N][K]);
		
	}
}