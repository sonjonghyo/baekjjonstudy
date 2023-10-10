import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int x;
		int y;
		int count;
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	static int N,M;
	static int map[][];
	static int dr[] = {-1,-1,0,1,1,1,0,-1};
	static int dc[] = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //열의 개수
		M = Integer.parseInt(st.nextToken()); //행의 개수
		map = new int[N][M]; //공간
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					answer = Math.max(answer, search(i,j));
				}
			}
		}
		System.out.println(answer);
		
	}
	private static int search(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		boolean visited[][] = new boolean[N][M];
		visited[x][y] = true;
		q.add(new Node(x, y, 0));
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int d = 0; d < 8; d++) {
				int nx = n.x + dr[d];
				int ny = n.y + dc[d];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) //범위를 나갔을때는 제외.
					continue;
				if(!visited[nx][ny] && map[nx][ny] == 1) { //만약 아기상어가 있는 공간이라면?
					return n.count + 1; //한칸 더 가야 있는 것이니 +1 을해주고 return 해준다.
				}else if(!visited[nx][ny] && map[nx][ny] == 0) { //안전 공간이라면?
					visited[nx][ny] = true;
					q.add(new Node(nx,ny, n.count + 1));
				}
			}
		}
		return 0;
	}
}