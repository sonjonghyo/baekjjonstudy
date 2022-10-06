import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int num[] = new int[n];
		int dp[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = num[0];
		for(int i = 1; i<n; i++) {
			if(dp[i-1]<0) {
				dp[i] = num[i];
				continue;
			}else {
				dp[i] = dp[i-1]+num[i];
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}
}