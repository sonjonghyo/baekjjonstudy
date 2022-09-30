import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r,c,dis;
		public Node(int r, int c,int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
		
	}
	static Queue<Node> q = new LinkedList<>();
	static Queue<Node> rq = new LinkedList<>();
	static int N,M,D;
	static int map[][];
	static boolean visited[];
	static int tmp[][]; //맵을 복사해주는 tmp
	static int max = Integer.MIN_VALUE;
	static int dr[] = {0, -1, 0}; //왼쪽위, 위, 오른쪽위 만 탐색하며
	static int dc[] = {-1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmp = new int[N][M];
		visited = new boolean[M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		backtrack(0,0);
		System.out.println(max);
	}
	private static void backtrack(int idx, int cnt) {
		if(cnt==3) {
			int result = shoot(); //쏘면서 1을 없앨건대 맵을 미리 복사해놓으면 나중에 다시 붙여서 쓰면됌.
			if(max<result) 
				max = result;
			return;				
		}
		for(int i = idx; i<M; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			backtrack(i+1,cnt+1);
			visited[i] = false;
		}
		
	}
	private static int shoot() {
		//visited가 true인 애들만 가능하게.
		//그때 D거리안에있는 애들 모아서 한번에제거.
		//중복인건 킬추가안함.
		//제거 후 한칸씩 내리기.
		for(int i = 0; i<N; i++) { //먼저 원본배열을 망가트리지 않게하기위해 맵 복사.
			for(int j = 0; j<M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		int kill = 0;
		for(int i = 0; i<N; i++) {
			if(i!=0) //처음 0일때는 그대로 가지고가고 그 이후부터 i가 돌때마다 한칸씩 내려줍니다.
				mapdown();
			for(int j = 0; j<M; j++) {
				int min = Integer.MAX_VALUE;
				int mnr = Integer.MAX_VALUE;
				int mnc = Integer.MAX_VALUE;
				if(visited[j]) {
					for(int a = N-D; a <= N+D; a++) {
						for(int b= j-D ; b<=j+D; b++) {
							if(a==N && b == N)
								continue;
							if(a<0 || b<0 || a>=N || b >= M)
								continue;
							int dis = Math.abs(N-a)+Math.abs(j-b);
							if(dis > D) //dis의 거리가 D보다 크면 continue;
								continue;
													
							if(tmp[a][b]==1) {
								q.add(new Node(a,b,dis)); //우선 적에 해당하는거 다 가져와.
							}
						}
					}
					while(!q.isEmpty()) {
						Node n = q.poll();
						if(min > n.dis) {
							min = n.dis;
							mnr = n.r;
							mnc = n.c;
						}else if(min == n.dis) {
							if(mnc > n.c) {
								mnr = n.r;
								mnc = n.c;
							}
						}
					}
					if(mnr != Integer.MAX_VALUE || mnc != Integer.MAX_VALUE)
						rq.add(new Node(mnr, mnc, min));
				}
				
			}
			while(!rq.isEmpty()) {
                Node n = rq.poll(); //큐에서 적에 해당하는 위치가 들어있는 노드를 빼옴.
                if(tmp[n.r][n.c]==1) { //그 위치에 만약 적이 서있다면
                    tmp[n.r][n.c]=0; //그 위치를 0으로 만들고
                    kill++; //kill을 1추가해준다.
                }else { //만약 서있지않다면
                    continue; //다시 while문 실행.
                }
			}
		}
		return kill;
	}
	private static void mapdown() { //맵을 한칸씩 내려주는 함수.
		for(int i = N-2; i>=0; i--) {
			for(int j = 0; j<M; j++) {
				tmp[i+1][j] = tmp[i][j];
				if(i==0) {
					tmp[0][j] = 0;
				}
			}
		}
	}
}