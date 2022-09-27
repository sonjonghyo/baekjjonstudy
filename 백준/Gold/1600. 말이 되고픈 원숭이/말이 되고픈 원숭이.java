import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = {-1,1,0,0}; //왼쪽 오른쪽 (원숭이 사방)
	static int dc[] = {0,0,-1,1}; //위 아래
	static int K,W,H;
	static int[] hdr = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int[] hdc = {-2, -2, -1, -1, 1, 1, 2, 2}; //말이 이동할 수 있는 8방향
	static class Node {
		int r;
		int c;
		int dis; //현재까지 이동한 횟수.
		int cnt; //말처럼 뛴 횟수
		public Node(int r, int c, int dis, int cnt) {
			this.r = r;
			this.c = c;
			this.dis = dis;
			this.cnt = cnt;
		}
	}
	static int min = Integer.MAX_VALUE;
	static int field[][]; //원숭이가 뛰어다닐 필드
	static boolean visited[][][]; //방문했는지 안했는지 확인. 말처럼 뛰고가는 부분이 3차원 마지막 부분에 저장됌.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		field = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min=BFS(0,0); //너비우선탐색 시작
		System.out.println(min);
		
	}

	public static int BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y,0,K)); //처음에 0,0 그리고 한번도 이동안했으므로 0, K를 큐에 넣어준다.
		visited[x][y][K] = true; //내가 넣어준 곳은 방문한 곳이므로 true로 만들어준다.
			while(!q.isEmpty()) {
				Node n = q.poll(); //빼줌.
				if(n.r == H-1 && n.c == W-1) { //빼줄때 노드에있는 r,c값이 배열의 마지막과 일치한다면 
					return n.dis; //그 값을 저장해리턴
				}
				for(int d = 0; d<4; d++) { //먼저 4방탐색을 한다.
					int nr = n.r + dr[d];
					int nc = n.c + dc[d];
					if(!arrout(nr,nc) && !visited[nr][nc][n.cnt] && field[nr][nc]==0) { //만약 현재 뛴 부분이 방문하지않았고, 0이라면.
						visited[nr][nc][n.cnt] = true; //true로 만들어줌.
						q.add(new Node(nr, nc, n.dis+1, n.cnt));
					}
				}
				if(n.cnt > 0) {
					for(int d = 0; d<8; d++) { //말이 이동할수 있는거리를 팔방탐색해줌.
						int nr = n.r + hdr[d];
						int nc = n.c + hdc[d];
						if(!arrout(nr,nc) && !visited[nr][nc][n.cnt-1] && field[nr][nc]==0) { //팔방탐색을 해주는데 말이 1을 건너뛸수있으므로 사이에있는 1은 의미없음. 도착지점이 0인지 아닌지만 확인.
							visited[nr][nc][n.cnt-1] = true;
							q.add(new Node(nr, nc, n.dis+1, n.cnt-1)); //만약 동작했다면 이동횟수+1해주고 말이 한번뛰었으니 사용횟수를 1 감소시켜준다.
						}
					}
				}
			}
			return -1;
		
	}
	public static boolean arrout(int nr, int nc) {
		if(nc<0 || nc>=W || nr<0 || nr>=H) //범위 밖이면 동작X
			return true;
		
		return false;
	}
}