import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int point[][] = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			point[a][b] = 1;
			point[b][a] = 1;	
		}
		boolean dfsvisited[] =new boolean[N+1];
		dfs(dfsvisited, point, V);
		
		sb.append("\n");
		
		boolean bfsvisited[] = new boolean[N+1];
		bfs(bfsvisited, point, V);
		
		System.out.println(sb);
	}

	private static void bfs(boolean[] bfsvisited, int[][] point, int V) {
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		bfsvisited[V] = true;
		sb.append(V).append(" ");
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i = 1; i < point.length; i++) {
				if(point[num][i] == 1 && !bfsvisited[i]) {
					q.add(i);
					bfsvisited[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
		
	}

	private static void dfs(boolean[] dfsvisited, int[][] point, int V) {
		dfsvisited[V] = true;
		sb.append(V).append(" ");
		for(int i = 1; i < point.length; i++) {
			if(point[V][i] == 1 && !dfsvisited[i])
				dfs(dfsvisited, point, i);
		}
	}
}
