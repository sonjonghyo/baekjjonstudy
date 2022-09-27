import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static int square[][];
	static int cr, cc; //현재위치
	static int sr, sc; //직사각형의 크기.
	static int lr, lc; //도착해야하는 위치
	static boolean visited[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int result;
	static class Node {
		int r;
		int c;
		int cnt;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		square = new int[H][W];
		visited = new boolean[H][W];
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		cr = Integer.parseInt(st.nextToken())-1;
		cc = Integer.parseInt(st.nextToken())-1;
		lr = Integer.parseInt(st.nextToken())-1;
		lc = Integer.parseInt(st.nextToken())-1;
		
		result = BFS(cr,cc);
		System.out.println(result);
	}
	public static int BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y,0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(lr==n.r && lc==n.c) { //만약 내가 설정한 목적지에 도달하면 return
				return n.cnt;
			}
			
			for(int d =0; d<4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(arrout(nr,nc) || visited[nr][nc])
					continue;
				if(check(nr,nc)) { //체크했을때 참이라면?
					visited[nr][nc] = true;
					q.add(new Node(nr,nc,n.cnt+1));
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
	
	public static boolean check(int nr, int nc) {
		for(int i = nr; i<nr+sr; i++) {
			for(int j = nc; j<nc+sc; j++) {
				if(arrout(i,j) || square[i][j]==1) //범위 바깥으로 나가거나 1이 있으면 갈수없으므로 false를 반환.
					return false;
			}
		}
		return true; //위를 다 했을때 없으면 true로 반환.
	}
}