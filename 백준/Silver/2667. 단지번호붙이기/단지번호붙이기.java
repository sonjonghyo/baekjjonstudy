import java.util.*;
import java.io.*;

public class Main {
	static int N; 
	static int map[][];
	static boolean visited[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		List<Integer> answer = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String S = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = S.charAt(j) - '0';
			}
		}
		int size = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) { //방문하지 않았고 붙일수있다면.
					size = 0;
					count = 1;
					visited[i][j] = true;
					danzi(i,j);
					answer.add(count);
				}
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		
		
	}
	private static void danzi(int i, int j) {
		for(int d= 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if(!visited[nr][nc] && map[nr][nc] == 1) {
				visited[nr][nc] = true;
				count++;
				danzi(nr, nc);
			}
		}
	}
}