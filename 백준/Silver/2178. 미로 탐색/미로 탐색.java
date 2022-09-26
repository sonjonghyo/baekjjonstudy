import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int x,y;
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int map[][];
	static int N, M;
	static int cx, cy; //현재위치를 보여줌
	static boolean visited[][];
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		BFS(0,0);
		System.out.println(map[N-1][M-1]);
		
	}
	public static void BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int d = 0; d<4; d++) {
				cx = node.x + dx[d];
				cy = node.y + dy[d];
				
				if(cx<0 || cx>=M || cy<0 || cy>=N)
					continue;
				if(!visited[cy][cx] && map[cy][cx] == 1) {
					q.add(new Node(cx, cy));
					visited[cy][cx] = true;
					
					map[cy][cx] = map[node.y][node.x] + 1;
					if(visited[N-1][M-1] == true)
						return;
				}
			}
		}
		
	}
}