import java.util.*;
import java.io.*;

public class Main {
	static int R, C, K;
	static char map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String S = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = S.charAt(j);
			}
 		}
		boolean visited[][] =new boolean[R][C];
		visited[R-1][0] = true;
		go(R-1, 0, visited,1);
		System.out.println(answer);
	}
	private static void go(int i, int j, boolean[][] visited, int cnt) {
		if(cnt == K ) {
			if(i == 0 && j == C-1) {
				answer++;
			}
			return;
		}
		for(int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			if(!visited[nr][nc] && map[nr][nc] == '.') {
				visited[nr][nc] = true;
				go(nr,nc, visited, cnt+1);
				visited[nr][nc] = false;
			}
		}
		
	}
}