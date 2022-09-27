import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r;
		int c;
		boolean punch;
		int dis;

		public Node(int r, int c, int dis, boolean punch) {
			this.r = r;
			this.c = c;
			this.dis = dis;
			this.punch = punch;
		}
	}
	static int map[][];
	static int N, M;
	static int nr, nc; // 현재위치를 보여줌
	static boolean visited[][][];
	static int result = 0;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		BFS(0, 0);
		if (result == 0) { //만약 result가 0이라는 것은 끝 위치에 도달하지 못한채 BFS함수가 끝난것이므로
			System.out.println(-1); //-1을 출력해준다.
		} else {
			System.out.println(result);
		}
	}

	public static void BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 1, false));
		visited[x][y][0] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();			
			if(node.r == N-1 && node.c == M-1) { //큐로 받은 위치가 마지막 위치라면.
				result = node.dis; //그때 안에있는 거리를 result에 저장해주고
				return; //return해준다.
			}

			for (int d = 0; d < 4; d++) {
				nr = node.r + dr[d];
				nc = node.c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) //범위 내에 없다면 다음 사방탐색시행.
					continue;

				if (map[nr][nc] == 0) { //벽이 아니라면
					if (!node.punch && !visited[nr][nc][0]) { //벽을 안부쉈다면
						visited[nr][nc][0] = true; //안부순 상태로 가므로 0인곳을 true로 만들어줌.
						q.add(new Node(nr, nc, node.dis + 1, false));
					} else if (node.punch && !visited[nr][nc][1]){ //벽을 부순적이있다면?
						visited[nr][nc][1] = true; //부순상태로 가는것이므로 1인곳을 true로 만들어줌.
						q.add(new Node(nr, nc, node.dis + 1, true));
					}
				} else if (map[nr][nc] == 1) { // 아직 펀치를 안썼다면? 펀치써서 뚫고가자.
					if(!node.punch) { //한번도 안부쉈다면
						visited[nr][nc][1] = true; //부숴주는 부분이 1이므로  그 부분을 true로 바꿔준다.
						q.add(new Node(nr, nc, node.dis + 1, true)); //부숴주고 다음거리로 이동하고
					}
				}
			}
		}
	}
}