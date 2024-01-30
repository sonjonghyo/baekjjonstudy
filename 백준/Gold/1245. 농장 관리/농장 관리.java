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
	static int N,M;
	static boolean visited[][];
	static int map[][];
	static int drc[][] = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					boolean flag = bfs(i,j,map[i][j]);
					if(flag) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
		
	}
	private static boolean bfs(int i, int j, int height) {
		Queue<Node> q = new LinkedList<>();
		visited[i][j] = true;
		q.add((new Node(i,j)));
		boolean bvisited[][] = new boolean[N][M];
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int d= 0 ; d < 8; d++) {
				int nr = n.r + drc[d][0];
				int nc = n.c + drc[d][1];
				//범위 내에 있을 때.
				if(outofBounds(nr,nc) && !bvisited[nr][nc]) {
					//인접한데 같은 높이니까 산봉우리라고 생각. 넣어주기.
					if(map[nr][nc] == height) {
						q.add((new Node(nr,nc)));
						visited[nr][nc] = true;
						bvisited[nr][nc] = true;
					//인접한데 더 높은 구간이 있으면 안돼.
					}else if(map[nr][nc] > height) {
						return false;
					}
				}
			}
		}
		return true;
		
	}
	
	private static boolean outofBounds(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
			return true;
		}
		return false;
	}
}