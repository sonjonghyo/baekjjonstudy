import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer>[] list; 
	static boolean visited[];
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		
		for(int i = 0; i<N; i++) { //인접 리스트 생성.
			list[i] = new ArrayList<>();
		}
		
		visited = new boolean[N];
		for(int i = 0; i<M; i++) { //인간관계 수.
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 0; i <N; i++) {
			dfs(i,1); //하나 방문했으니 깊이는 1로 시작. A,B,C,D,E에 관해 방문시 1을 출력.
			
			if(result == 1) break; //1에 도달했다는 것은 조건에 만족하는것이 있는것. 바로 끝내줌.
		}
		if(result == 1) {
			System.out.println(result);
		}else {
			System.out.println(0);
		}
		
	}
	
	public static void dfs(int idx, int d) {
		if(d==5) { //조건과 같은 친구관계를 확인해야하므로 확인해줌.
			result = 1; //조건에 맞으면 result를 1로만들어줌.
			return;
		}
		
		visited[idx] = true; //나는 방문했으니 true로 바꿔줘.
		
		for(int n : list[idx]) {
			if(!visited[n]) { //다음 곳에 방문했는지 체크.
				dfs(n, d+1); //다음 곳으로 보내주고 깊이+1를 해줌.
			}
		}
		visited[idx] = false; //나는 끝났으니 flase로 만들어준다.
	}
}