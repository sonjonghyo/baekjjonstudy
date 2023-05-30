import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int price[] = new int[N+1];
		int dp[] = new int[1001];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + price[j]);
			}
		}
		System.out.println(dp[N]);
	}
}
