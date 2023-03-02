import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r;
		int c;
		int dis;
		public Node(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
	static int r, c;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static char map[][];
	static int result = 0;
	static Queue<Node> treasure;
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];
		treasure = new LinkedList<>();
		for(int i = 0; i < r; i++) {
			String LORW = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = LORW.charAt(j);
			}
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == 'L') {
					visited[i][j] = true;
					treasure.add(new Node(i, j, 0));
					checkdis();
					//visited다시 전부 false로 만들어주어야함.
					makefalse();
				}
			}
		}
		System.out.println(result);
		
		
	}
	private static void makefalse() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				visited[i][j] = false;
			}
		}
	}
	private static void checkdis() {
		while(!treasure.isEmpty()) {
			Node n = treasure.poll();
			if(n.dis > result)
				result = n.dis;
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(OutOfBounds(nr,nc)) { 
					if(!visited[nr][nc] && map[nr][nc] == 'L') {
						visited[nr][nc] = true;
						treasure.add(new Node(nr, nc, n.dis + 1));
					}
				}
			}
		}
	}
	private static boolean OutOfBounds(int nr, int nc) {
		return (nr >= 0 && nr < r && nc >= 0 && nc < c);
	}
}