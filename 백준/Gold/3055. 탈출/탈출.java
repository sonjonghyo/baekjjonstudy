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
	static int R,C;
	static char map[][];
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	static Queue<Node> q;
	static Queue<Node> water;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		q = new LinkedList<>();
		water = new LinkedList<>();
		for(int i = 0; i<R; i++) {
			String s = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if(s.charAt(j)=='S')
					q.add(new Node(i,j,0));
				if(s.charAt(j)=='*')
					water.add(new Node(i,j,0));
			}
		}
		bfs();
		if(result == 0) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(result);
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int i = 0; i<qsize; i++) {
				Node n = q.poll();
				for(int d = 0; d<4; d++) {
					boolean flag = false;
					int nr = n.r + dr[d];
					int nc = n.c + dc[d];
					if(!in(nr,nc))
						continue;
					if(map[nr][nc]=='.' && map[nr][nc] != '*' && map[nr][nc] != 'X' || map[nr][nc]=='D') {
						if(map[nr][nc]=='D') {
							result = n.cnt+1;
							return;
						}
						for(int a = 0; a<4; a++) {
							int nnr = nr + dr[a];
							int nnc = nc + dc[a];
							if(in(nnr,nnc) && map[nnr][nnc]=='*') {
								flag = true;
								break;
							}
						}
						if(flag) {
							continue;
						}else {
							q.add(new Node(nr,nc,n.cnt+1));
							map[nr][nc] = 'S';
							
						}
					}				
				
				}
			}
			int size = water.size();
			for(int i = 0; i < size; i++) {
				Node n = water.poll();
				for(int d = 0; d<4; d++) {
					int nr = n.r + dr[d];
					int nc = n.c + dc[d];
					if(in(nr,nc) && map[nr][nc]!='X' && map[nr][nc]!='D' && map[nr][nc]=='.') {
						map[nr][nc] = '*';
						water.add(new Node(nr,nc,0));
					}
				}
			}
		}
		
	}
	private static boolean in(int nr, int nc) {
		return (nr >= 0 && nr < R && nc >= 0 && nc < C);
	}
}