import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int arr[];
	static int tmp[];
	static boolean visited[];
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		tmp = new int[N];
		dfs(0);
		System.out.println(sb);
	}
	private static void dfs(int cnt) {
		if(cnt == N) {
			for(int i = 0; i<N; i++) {
				if(i!=N-1) {
					sb.append(tmp[i]).append(" ");
				}else {
					sb.append(tmp[i]);
				}
			}
			sb.append("\n");
		}
		
		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[cnt] = i+1;
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
	}
}