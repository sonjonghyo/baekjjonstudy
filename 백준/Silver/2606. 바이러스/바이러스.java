import java.util.*;
import java.io.*;

public class Main {
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int virus[][] = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			virus[a][b] = 1;
			virus[b][a] = 1;
		}
		
		boolean visited[] = new boolean[N+1];
		visited[1] = true;
		dfs(visited, virus, 1);
		System.out.println(answer);
	}
	private static void dfs(boolean[] visited, int[][] virus, int tmp) {
		for(int i = 1; i < visited.length; i++) {
			if(virus[tmp][i] == 1 && !visited[i]) {
				visited[i] = true;
				answer++;
				dfs(visited, virus, i);
			}
		}
	}
}