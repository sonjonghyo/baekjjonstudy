import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int drc[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static Queue<Node> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			String S = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = S.charAt(j) - '0';
			}
		}
		visited[0][0] = true;
		q.add(new Node(0,0));
		bfs();
		System.out.println(map[N-1][M-1]);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = n.r + drc[d][0];
				int nc = n.c + drc[d][1];
				if(outofRange(nr,nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					map[nr][nc] = map[n.r][n.c] + 1;
					visited[nr][nc] = true;
					q.add(new Node(nr,nc));
				}
				//끝까지 갔으면 더 볼필요없지.
				if(nr == N-1 && nc == M-1)
					return;
			}
		}
		
	}
	
	private static boolean outofRange(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}
}