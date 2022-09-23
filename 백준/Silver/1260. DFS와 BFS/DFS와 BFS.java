import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean dvisited[];
	static boolean fvisited[];
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1]; //인접행렬 생성(0번 제외하고 1~4까지 들어간다하고 +1을 해줌.
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1; //간선이 서로 양방향이므로 바꾸어서도 1을 넣어주어 있다는 것을 알림.
			arr[b][a] = 1;
		}
		dvisited = new boolean[N+1]; //위와 마찬가지.
		fvisited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		
		bfs(V);
		
		System.out.println(sb);
	}
	public static void dfs(int V) { //깊이우선 탐색.
		dvisited[V] = true;
		sb.append(V).append(" "); //먼저 V에 해당하는 정점을 먼저 탐색하므로 V를 저장해준다.
		
		for(int i = 1; i < arr.length; i++) { //1부터 시작하는 이유도 0번은 사용하지 않기때문에.
			if(arr[V][i] == 1 && !dvisited[i])
				dfs(i);
		}	
	}
	public static void bfs(int V) { //너비우선 탐색
		q.add(V); //먼저 큐에 V를 넣어주고
		fvisited[V] = true; //이 구간은 방문한 곳이니 true로 변경해준다.
		sb.append(V).append(" "); //그러고 sb에 저장.
		while(!q.isEmpty()) { //q가 전부 비워질때까지 while문을 돌린다.
			int tmp = q.poll(); //큐에 저장된 것을 빼고
			for(int i = 1; i< arr.length; i++) {
				if(arr[tmp][i] == 1 && !fvisited[i]) { //그곳에 인접하는 노드들을 전부 확인.
					q.add(i); //조건에 맞으면 큐에 넣고
					fvisited[i] = true; //방문했으니 true로 변경해준다.
					sb.append(i).append(" ");
				}
			}
		}
		
	}
}