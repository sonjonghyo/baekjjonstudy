import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dp[][];
	static int dr[] = {0,1,1};
	static int dc[] = {1,0,1};
	static int N,M;
	static int miro[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new int[N][M];
		dp = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum();
		System.out.println(dp[N-1][M-1]);
	}
	
	public static void sum() {
		dp[0][0] = miro[0][0];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				for(int d = 0; d<3; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if(dp[nr][nc] < miro[nr][nc]+dp[i][j]) {
							dp[nr][nc] = miro[nr][nc] +dp[i][j];
						}
					}
					
				}
			}
		}
	}
}