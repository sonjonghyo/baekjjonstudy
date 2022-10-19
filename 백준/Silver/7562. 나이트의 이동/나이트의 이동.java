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
	static int dr[] = {-1,-2,-2,-1,1,2,2,1}; //나이트의 이동반경을 dr, dc로 표현.
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
			map = new int[L][L]; //맵의 크기 설정.
			visited = new boolean[L][L]; //방문했는지 안했는지 보여줌.
			arr = new int[2][2];
			for(int i = 0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); //(0,0) (0,1)에는 시작위치가 
				arr[i][1] = Integer.parseInt(st.nextToken()); //(1,0) (1,1)에는 도착위치가 담길것.
			}
			bfs(arr[0][0],arr[0][1]);
			sb.append(result); //결과값을 stringbuilder에 저장해주고
			if(tc!=T) //테스트케이스가 아직 끝나지않았다면?
				sb.append("\n"); //개행문자를 추가해줍니다.
		}
		System.out.println(sb); //출력.
		
	}
	private static void bfs(int i, int j) { //너비 탐색시작.
		Queue<Node> q = new LinkedList<>();
		int cnt = 0;
		q.add(new Node(i,j,cnt)); //큐에 시작위치와 현재 움직인 횟수를 담아줄것.
		visited[i][j] = true;
		
		while(!q.isEmpty()) { //큐가 다 빌때까지 돌기
			Node n = q.poll();
			if(n.r == arr[1][0] && n.c == arr[1][1]) { //만약 뺐는데 그때의 n.r,n.c가 도착지점이라면?
				result = n.cnt; //그때의 이동거리를 result에 담아주고
				return; //bfs함수를 끝내줍니다.
			} 
			for(int d = 0; d<8; d++) { //나이트가 이동할수있는 부분 8방탐색.
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(nr>=0 && nr<L && nc>=0 && nc<L) { //범위 안에 들어와야지만.
					if(!visited[nr][nc]) { //방문안한자리라면
						visited[nr][nc] = true; //방문했다고 true로 변경해주며
						q.add(new Node(nr,nc,n.cnt+1)); //큐에 이동거리를 +1해주고 그 다음위치 nr,nc를 담아준다.
					}
				}
			}
		}
	}
}