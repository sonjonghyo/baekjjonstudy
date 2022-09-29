import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int p[];
	static int edges[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		// 크루스칼을 하기위해선 가중치를 정렬해야함
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		p = new int[V + 1]; // 대표를 저장할 배열
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}

		long ans = 0;
		int pick = 0;
		// 간선 선택.
		for (int i = 0; i < E; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			if (px != py) { // 대표가 같으면 패스 다르면 union해줌.
				union(px, py);
				ans += edges[i][2];
				pick++;
			}

			if (pick == V - 1)
				break;
		}

		System.out.println(ans);
	}

	private static void union(int x, int y) {
		p[y] = x; // 합쳐주기.

	}
	private static int findSet(int i) {
		if (i != p[i]) // 현재 i와 p[i]의 값이 다르다? 대표자가 달라?
			p[i] = findSet(p[i]); // 대표자를 찾아 나선다.
		return p[i]; // 대표자와 i랑 같으면 p[i]를 리턴해줌.
	}

	private static void makeSet(int i) {
		p[i] = i; // 먼저 나 자신을 대표로 초기화해줌.
	}
}