import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int floor[] = new int[N+1];
		for(int i = 1; i<=N; i++) {
			floor[i] = Integer.parseInt(br.readLine());
		}
		int dp[] = new int[N+1];
		dp[0] = floor[0];
		dp[1] = floor[1];
		if(N>=2) { //계단이 1개일때를 고려해서 if문을 사용해줌.
			dp[2] = floor[1] + floor[2];
		}
		for(int i = 3; i<=N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + floor[i - 1]) + floor[i];
		}
		System.out.println(dp[N]);
	}
}