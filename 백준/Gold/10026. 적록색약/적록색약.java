import java.io.*;

public class Main {
	static int N;
	static char RGB[][];
	static int drc[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean visited[][];
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		RGB = new char[N][N];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				RGB[i][j] = s.charAt(j);
			}
		}
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					dfs(i,j,RGB[i][j]);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(" ");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(RGB[i][j] == 'G') {
					RGB[i][j] = 'R';
				}
			}
		}
		cnt = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					dfs(i,j, RGB[i][j]);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
		
	}
	
	private static void dfs(int r, int c, char color) {
		for(int d = 0; d < 4; d++) {
			int nr = r + drc[d][0];
			int nc = c + drc[d][1];
			//범위 내일 경우에
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(!visited[nr][nc] && RGB[nr][nc] == color) {
					visited[nr][nc] = true;
					dfs(nr, nc, color);
				}
			}
		}
	}
}