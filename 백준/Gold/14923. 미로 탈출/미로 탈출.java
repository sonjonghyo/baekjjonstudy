import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r;
		int c;
		int dis;
		int magic;
		public Node(int r, int c, int dis, int magic) {
			this.r = r;
			this.c = c;
			this.dis = dis;
			this.magic = magic;
		}
	}
	static int N, M;
	static int Hx, Hy, Ex, Ey; //시작위치(x,y), 끝위치(x,y)
	static int miro[][]; //미로의 크기.
	static Queue<Node> q;
	static boolean visited[][][];
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {-1,1, 0, 0};
	static int minDistance = 0; //가장 짧은거리.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		miro = new int[N][M];
		visited = new boolean[N][M][2];
		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken()) - 1;
		Hy = Integer.parseInt(st.nextToken()) - 1;
		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken()) - 1;
		Ey = Integer.parseInt(st.nextToken()) - 1;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q = new LinkedList<>();
		q.add(new Node(Hx, Hy, 0, 0)); //큐에 추가
		visited[Hx][Hy][0] = true;
		escape(); //탈출하기!
		if(minDistance == 0) {
			System.out.println(-1);
		}else {
			System.out.println(minDistance);
		}
	}
	private static void escape() {
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.r == Ex && n.c == Ey) { //탈출 경로라면?
				minDistance=n.dis;
				return;
			}
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(outOfBounds(nr,nc)) { //범위 안일경우에
					if(miro[nr][nc] == 0) { //갈수있다면?
						if(n.magic == 0 && !visited[nr][nc][0]) { //벽을 안부신 상황이라면?
							visited[nr][nc][0] = true;
							q.add(new Node(nr ,nc, n.dis+1, 0));
						}else if(n.magic == 1 && !visited[nr][nc][1]) { //벽 부순적 있으면?
							visited[nr][nc][1] = true;
							q.add(new Node(nr, nc, n.dis +1, 1));
						}
					}else { //막혀있으면?
						if(n.magic == 0) { //한번 부술수 있으면?
							visited[nr][nc][1] = true; //부순채로 이동
							q.add(new Node(nr, nc, n.dis+1, 1));
						}
					}
				}
			}
		}
		
	}
	private static boolean outOfBounds(int nr, int nc) {
		return (nr >= 0 && nr < N && nc >= 0 && nc < M);
	}
}