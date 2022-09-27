import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N,K;
	static class Node {
		int r;
		int c;
		int cnt;
		int high;
		int cut;
		boolean visit[][];
		public Node(int r, int c, int cnt, int high, int cut, boolean[][] visit) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.high = high;
			this.cut = cut;
			this.visit = visit;
		}
	}
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int rmax;
	static int arr[][];
	static Queue<Node> q = new LinkedList<>();
	static boolean visited[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			rmax = 0;
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			K = sc.nextInt();
			int max = 0;
			arr = new int[N][N];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] > max) //가장 큰 봉우리 결정.
						max = arr[i][j];
				}
			}
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(arr[i][j]==max) {
						visited = new boolean[N][N];
						BFS(i,j,max);			
					}
				}
			}
			sb.append(rmax);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	public static void BFS(int r, int c, int max) {
		q.add(new Node(r,c,1,max,1,visited));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			boolean[][] realvisit = new boolean[N][N];	
			realvisit = copy(n.visit);
			realvisit[n.r][n.c] = true;
			
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				
				if(nr<0 || nr >= N || nc<0 || nc >= N)
					continue;
				if(n.visit[nr][nc])
					continue;
				if(arr[nr][nc] < n.high) {
					q.add(new Node(nr,nc, n.cnt+1,arr[nr][nc],n.cut,realvisit)); //nr,nc의 위치를 넣어주고 한칸이동했으므로 n.cnt+1을해주고 봉우리의 최대값은
					//arr[nr][nc]의 값이고 마지막은 잘랐는지 안잘랐는지 확인.
				} else if(n.cut == 1) {
					for(int i =1; i<=K; i++) {
						if(arr[nr][nc]-i < n.high ) {
							q.add(new Node(nr,nc,n.cnt+1,arr[nr][nc]-i,0,realvisit));
					}
				}
			}
		}
			if(rmax < n.cnt)
				rmax = n.cnt;
		}
	}
	
	public static boolean[][] copy(boolean[][] co) {
		boolean[][] check = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			System.arraycopy(co[i], 0, check[i] , 0, check[i].length);
		}
		
		return check;
	}
}