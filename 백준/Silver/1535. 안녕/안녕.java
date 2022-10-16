import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int hp[] = new int[N+1];
		int happy[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			hp[i] = Integer.parseInt(st.nextToken()); //깎이는 HP
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			happy[i] = Integer.parseInt(st.nextToken()); //얻는 행복.
		}
		int dp[][] = new int[N+1][101];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=99; j++) { //내 최대 HP는 99까지.. 그 이상은 죽어요
				if(hp[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-hp[i]]+happy[i]);					
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][99]);
	}
}