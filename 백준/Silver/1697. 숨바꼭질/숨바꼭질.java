import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static int num[];
	static int N, K;
	static int X[] = { -1, 1, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		num = new int[100001];

		bfs(N);
	}

	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;
		while (!q.isEmpty()) {
			int n = q.poll();
			if (n == K) {
				System.out.println(num[K]);
				return;
			}
			int nx = 0;
			for (int d = 0; d < 3; d++) {
				if (d == 2) {
					nx = n * X[d];
				} else {
					nx = n + X[d];
				}

				if (nx >= 0 && nx <= 100000) { //범위 내에 있는것만 동작.
					if (!visited[nx]) { //방문한건 굳이 또 갈필요가없음. (동선이 낭비됌.)
						q.add(nx); //방문안했으면 큐에 추가.
						num[nx] = num[n] + 1; //방문한곳 이전에 했던곳보다 1번더 간것으로 추가.
						visited[nx] = true; //방문됐으니 true로 변경.
					}
				}
			}
		}
	}
}