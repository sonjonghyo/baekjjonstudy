import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x,y,z;
		int minute;
		public Node(int x, int y, int z, int minute) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.minute = minute;
		}
	}
	static int L, R, C;
	static char building[][][];
	static boolean visited[][][];
	static Queue<Node> sangbum;
	static int result = 0;
	static int drc[][] = {{1,0,0},{-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1}, {0,0,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {			
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0) {
				break; //셋다 0이면 while문 끝내주기
			}
			result = 0;
			String floor = "";
			building = new char[L][R][C];
			visited = new boolean[L][R][C];
			sangbum = new LinkedList<>();
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					floor = br.readLine();
					for(int k = 0; k < C; k++) {
						building[i][j][k] = floor.charAt(k);
						if(floor.charAt(k) == 'S') {
							visited[i][j][k] = true;
							sangbum.add(new Node(i, j, k, 0)); //처음 시작 부분을 추가해줍니다.
						}
					}
				}
				br.readLine();
			}
			start(); //끝지점 찾아가기 스타트.
			if(result == 0) { //결과를 못찾았으면?
				sb.append("Trapped!").append("\n");
			}else {
				sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
			}
		}
		System.out.println(sb);
	}
	private static void start() {
		while(!sangbum.isEmpty()) { //비어있지 않을때까지 돌리기.
			Node n = sangbum.poll();			
			for(int d = 0; d < 6; d++) {
				int nx = n.x + drc[d][0];
				int ny = n.y + drc[d][1];
				int nz = n.z + drc[d][2];
				if(outOfRange(nx,ny,nz)) { //배열범위 안이라면?
					if(building[nx][ny][nz] == 'E') { //도착했으면 끝내주기.
						result = n.minute+1;
						return;
					}else if(!visited[nx][ny][nz] && building[nx][ny][nz] == '.') { //이동가능한 공간이라면?
						visited[nx][ny][nz] = true;
						sangbum.add((new Node(nx,ny,nz, n.minute+1)));
					}
				}
			}
		}
		
	}
	private static boolean outOfRange(int nx, int ny, int nz) {
		return (nx >= 0 && nx < L && ny >= 0 && ny < R && nz >= 0 && nz < C);
	}
}