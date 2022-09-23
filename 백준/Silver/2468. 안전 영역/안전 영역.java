import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//4방탐색
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0}; //상하좌우
	static int area[][];
	static int N;
	static boolean visited[][];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int cnt = 0;
	static int print[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j] > max)
					max = area[i][j];
				if(area[i][j] < min)
					min = area[i][j];
			}
		}
		print = new int[max+1];
		if(min==max) {
			min = max-1;
		}
		for(int a = min; a<max; a++) {
			cnt = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(area[i][j] > a && !visited[i][j]) {
						cnt++;
						hownum(i,j,a);
					}
				}
			}
			print[a] = cnt;
			for(boolean c[] : visited) {
				Arrays.fill(c, false);				
			}
		}
		Arrays.sort(print);
		System.out.println(print[print.length-1]);
	}
	public static void hownum(int i, int j, int dept) {
		visited[i][j] = true;
		for(int d = 0; d<4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx<0 || ny<0 || nx >=N || ny>=N) 
				continue;
			if(!visited[nx][ny] && area[nx][ny] > dept)
				hownum(nx,ny,dept);
		}
	}
}