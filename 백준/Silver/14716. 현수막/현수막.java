import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int banner[][];
	static int drc[][] = {{-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}};
	static int sum = 0;
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //현수막 세로길이
		M = Integer.parseInt(st.nextToken()); //현수막 가로길이
		banner = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				banner[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && banner[i][j] == 1) {
					sum++;
					check(i, j);
				}
			}
		}
		System.out.println(sum);
		
	}
	private static void check(int r, int c) {
		for(int d = 0; d < 8; d++) {
			int nr = r + drc[d][0];
			int nc = c + drc[d][1];
			if(outofBounds(nr,nc)) {
				if(!visited[nr][nc] && banner[nr][nc] == 1) {
					visited[nr][nc] = true;
					check(nr,nc);
				}
			}
		}
		
	}
	private static boolean outofBounds(int nr, int nc) {
		return (nr >= 0 && nr < N && nc >= 0 && nc < M);
	}
}