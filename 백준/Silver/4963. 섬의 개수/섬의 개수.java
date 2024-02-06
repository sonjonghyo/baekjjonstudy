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
	static int drc[][] = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
	static int land[][];
	static int N,M;
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			//둘다 0일 경우 끝내기.
			if(N == 0 && M == 0) {
				break;
			}
			//바다 지도
			land = new int[N][M];
			//방문처리 배열.
			visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					land[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					//섬이고 아직 방문하지 않은 곳일 경우 bfs동작. 그러고 섬의 개수 추가.
					if(land[i][j] == 1 && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			//섬 추가.
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	private static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		visited[i][j] = true;
		q.add((new Node(i, j)));
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int d = 0; d < 8; d++) {
				int nr = n.r + drc[d][0];
				int nc = n.c + drc[d][1];
				//바다 경계 내에 있으며 아직 방문하지 않았다면?
				if(outofBounds(nr, nc) && !visited[nr][nc] && land[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new Node(nr,nc));
				}
			}
		}
	}
	
	//바다 밖으로 나가는 것 체크해줄 함수입니다.
	private static boolean outofBounds(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}
}