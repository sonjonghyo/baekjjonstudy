import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int N,M;
	static boolean visited[]; //방문처리.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수.
		arr = new int[N+1][N+1];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1; //해당하는 부분 전부 1로 만들어주기. 인접배열사용.
			arr[b][a] = 1; 
		}
		
		int result = 0 ;
		visited = new boolean[N+1];
		// dfs 탐색
		for(int i = 1; i <= N; i++) { //어짜피 0은 안써서 제외하고 N까지 돌리면됌.
			if(!visited[i]) { // 방문한 적 없는 노드라면 dfs.
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}
	private static void dfs(int idx) {
		if(visited[idx]) //방문했었으면 dfs로 볼필요가없음. 바로 return.
			return;
		visited[idx] = true; //방문안했으면 방문처리해주고
		for(int i = 1; i<=N; i++) { //그 행에해당하는 부분 전부 찾기.
			if(arr[idx][i] == 1) {
				dfs(i);
			}
		}
	}	
}