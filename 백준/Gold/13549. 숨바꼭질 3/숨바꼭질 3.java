import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int idx,cnt;
		public Node(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
	static boolean visited[];
	static int N, K;
	static int X[] = { -1, 1, 2 };
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		result = Integer.MAX_VALUE;
		bfs(N);
		System.out.println(result);
	}

	private static void bfs(int x) {
		Deque<Node> q = new LinkedList<>();
		q.add(new Node(x,0));
		visited[x] = true;
		while (!q.isEmpty()) {
			Node n = q.poll();
			visited[n.idx] = true;
			if (n.idx == K) {
				result = Math.min(result, n.cnt);
			}
			int nx = 0;
			for (int d = 2; d >= 0; d--) {
				if (d == 2) {
					nx = n.idx * X[d];
				} else {
					nx = n.idx + X[d];
				}

				if (nx >= 0 && nx <= 100000) { //범위 내에 있는것만 동작.
					if (!visited[nx]) { //방문한건 굳이 또 갈필요가없음. (동선이 낭비됌.)
						if(d!=2) {
							q.add(new Node(nx, n.cnt+1));
						}else {
							q.add(new Node(nx, n.cnt));
						}
						
					}
				}
			}
		}
	}
}