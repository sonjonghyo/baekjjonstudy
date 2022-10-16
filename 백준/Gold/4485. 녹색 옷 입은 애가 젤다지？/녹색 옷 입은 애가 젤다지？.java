import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{ //먼저 노드 클래스를 만들어주어
		//가중치 별로 저장하기 위해 Comparable을 사용함.
		int r,c,size;
		
		public Node(int r, int c ,int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}

		@Override
		public int compareTo(Node o) { //가중치가 낮은것 부터 먼저 뽑기.
	
			return this.size - o.size;
		}
	}
	static int dr[] = {0,0,-1,1}; //사방탐색을 위해 사용
	static int dc[] = {-1,1,0,0};
	static int N;
	static int map[][]; //루피를 저장
	static int size[][]; //이동할 경로 저장 (처음에 전부 가장큰수로 저장해줌)
	static PriorityQueue<Node> pq; //가중치별로 정렬해주기위해 우선순위 큐 사용
	static int INF = Integer.MAX_VALUE;
	static boolean visited[][]; //방문체크 위해 사용.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int cnt = 1; //카운트를 위해 사용해줌.
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) //N이 0일때 while문을 종료시켜준다.
				break;
			sb.append("Problem ").append(cnt).append(": ");
			map = new int[N][N]; //루피를 저장할 맵 생성
			size = new int[N][N]; //이동경로를 저장할 맵 생성
			visited = new boolean[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); //루피 저장
					size[i][j] = INF; //모든 사이즈에 가장 큰 값 저장.
				}
			}
			pq = new PriorityQueue<>(); //우선순위 큐 생성해주고
			bfs(0,0,map[0][0]); //BFS사용(사방탐색해서 주위에서 가장 짧은 거리를 찾기위해)
			sb.append(size[N-1][N-1]).append("\n"); //마지막에 빼앗긴 루피의 정보가 담긴 size배열의 마지막부분을 출력하면 정답.
			cnt++;
		}
		System.out.println(sb);
	}
	private static void bfs(int r, int c, int price) {
		visited[r][c] = true; //먼저 시작할때 0,0은 true가 되고
		pq.add(new Node(r,c,price)); //우선순위큐에 0,0에 대한 정보 저장
		
		while(!pq.isEmpty()) { //pq가 빌때까지 사용
			Node n = pq.poll();
			
			for(int d = 0; d<4; d++) { //사방탐색
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(rangein(nr,nc) && !visited[nr][nc] && size[nr][nc] > (map[nr][nc] + n.size)) {
					//map의 nr,nc에 대해 방문하지 않았고 
					//size가 nr,nc의 루피와 현재 빼앗긴 루피보다 커야 이동해야함(작은데 이동하면 최소가 아님.)
					size[nr][nc] = map[nr][nc] + n.size; //조건을 충족했을시 size에 저장.
					visited[nr][nc] = true; //map의 nr,nc는 방문했으니 true로 변경.
					pq.add(new Node(nr,nc,size[nr][nc])); //우선순위 큐에 새로운 nr,nc,그곳의 누적루피를 저장해준다.
				}
				
			}
		}
		
	}	
	private static boolean rangein(int nr,int nc) { //범위 안에 있는지 확인 (true일때가 범위 이내)
		return (nr >= 0 && nr < N && nc >= 0 && nc < N);
	}
}