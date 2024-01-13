import java.io.*;
import java.util.*;

public class Main {
	static int map[][];
	static int N;
	static boolean visited[][];
	static int drc[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j])
					max = map[i][j];
			}
		}
		int cnt = 0;
		for(int num = 0; num < max; num++) {
			visited = new boolean[N][N];
			cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > num && !visited[i][j]) {
						dfs(i,j,num);
						cnt++;
					}
				}
			}
			if(cnt > answer)
				answer = cnt;			
		}
		System.out.println(answer);
	}
	private static void dfs(int r, int c, int num) {
		for(int d = 0; d < 4; d++) {
			int nr = r + drc[d][0];
			int nc = c + drc[d][1];
			if(outofRange(nr,nc) && map[nr][nc] > num && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr,nc,num);
			}
		}
		
	}
	private static boolean outofRange(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}
}