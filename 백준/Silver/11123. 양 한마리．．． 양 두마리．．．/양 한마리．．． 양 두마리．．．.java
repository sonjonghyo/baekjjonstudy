import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static char grid[][];
	static boolean checked[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int sheepswarm = 0;
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			grid = new char[H][W];
			checked = new boolean[H][W];
			for(int i = 0; i < H; i++) {
				String s = br.readLine();
				for(int j = 0; j < W; j++) {
					grid[i][j] = s.charAt(j);
				}
			}
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(!checked[i][j] && grid[i][j] == '#') {
						sheepswarm++;
						checked[i][j] = true;
						checkswarm(i,j);
					}
				}
			}
			sb.append(sheepswarm);
			if(tc != T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void checkswarm(int i, int j) {
		for(int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr >= 0 && nr < H && nc >= 0 && nc < W) {
				if(!checked[nr][nc] && grid[nr][nc] == '#') {
					checked[nr][nc] = true;
					checkswarm(nr,nc);
				}
			}
		}	
	}
}