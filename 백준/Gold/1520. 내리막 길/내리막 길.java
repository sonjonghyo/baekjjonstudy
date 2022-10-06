import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int map[][];
	static int N,M;
	static int result;
	static long dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new long[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		long ans = dfs(0,0);
		System.out.println(ans);
	}
	public static long dfs(int x, int y) {
		if(x==N-1 && y==M-1) {
			return 1;
		}
		if(dp[x][y]!=-1)
			return dp[x][y];
	
		dp[x][y] = 0;
		for(int d = 0; d<4; d++) {
			int nr = x + dr[d];
			int nc = y + dc[d];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if(map[x][y] > map[nr][nc])
					dp[x][y] += dfs(nr,nc);				
			}
			
		}
		return dp[x][y];
	}
}