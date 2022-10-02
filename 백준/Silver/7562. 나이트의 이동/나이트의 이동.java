import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r,c,cnt;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int map[][];
	static int dr[] = {-1,-2,-2,-1,1,2,2,1};
	static int dc[] = {-2,-1,1,2,2,1,-1,-2};
	static int L;
	static int arr[][];
	static int result;
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 횟수
		for(int tc = 1; tc<=T; tc++) {
			L = Integer.parseInt(br.readLine());
			result = 0;
			map = new int[L][L];
			visited = new boolean[L][L];
			arr = new int[2][2];
			for(int i = 0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); //(0,0) (0,1)에는 시작위치가 
				arr[i][1] = Integer.parseInt(st.nextToken()); //(1,0) (1,1)에는 도착위치가 담길것.
			}
			bfs(arr[0][0],arr[0][1]);
			sb.append(result);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		
	}
	private static void bfs(int i, int j) { //너비 탐색시작.
		Queue<Node> q = new LinkedList<>();
		int cnt = 0;
		q.add(new Node(i,j,cnt)); //큐에 시작위치와 현재 움직인 횟수를 담아줄것.
		visited[i][j] = true;
		
		while(!q.isEmpty()) { //큐가 다 빌때까지 돌기
			Node n = q.poll();
			if(n.r == arr[1][0] && n.c == arr[1][1]) {
				result = n.cnt;
				return;
			}
			for(int d = 0; d<8; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(nr>=0 && nr<L && nc>=0 && nc<L) { //범위 안에 들어와야지만.
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Node(nr,nc,n.cnt+1));
					}
				}
			}
		}
	}
}