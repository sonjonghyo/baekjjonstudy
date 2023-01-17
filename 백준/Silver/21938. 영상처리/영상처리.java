import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T;
	static int RGB[][];
	static boolean visited[][];
	static int task;
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int sum = 0;
		int cnt = 0;
		RGB = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M * 3; j++) {
				cnt++;
				sum += Integer.parseInt(st.nextToken());
				if(cnt == 3) {
					cnt = 0;
					sum /= 3;
					RGB[i][idx++] = sum;
					sum = 0;
				}
			}
		}
		T = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			for(int j = 0;  j < M; j++) {
				if(RGB[i][j] >= T) {
					RGB[i][j] = 255;
				}else {
					RGB[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && RGB[i][j] == 255) {
					task++;
					check(i,j);
				}
			}
		}
		System.out.println(task);
	}
	private static void check(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(outOfBounds(nr,nc)) {
				if(!visited[nr][nc] && RGB[nr][nc] ==255) {
					visited[nr][nc] = true;
					check(nr,nc);
				}
			}
		}
		
	}
	private static boolean outOfBounds(int nr, int nc) {
		return (nr >= 0 && nr < N && nc >= 0 && nc < M);
	}
}