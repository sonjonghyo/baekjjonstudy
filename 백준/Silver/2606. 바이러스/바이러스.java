import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int com[][];
	static boolean bvisited[];
	static int cnt;
	static int C;
	static int N;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		C = Integer.parseInt(br.readLine()); //컴퓨터의 개수. 배열의 크기.
		N = Integer.parseInt(br.readLine()); //컴퓨터 번호 쌍. for문 돌릴 개수.
		com = new int[C+1][C+1]; //2차원배열로 만들어 관리가 편하게 해줌.(연결된 곳은 1 연결안된 곳은 0)
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			com[a][b] = 1; //서로 연결되어있다 했으니
			com[b][a] = 1; //양쪽다 1로 만들어줌.
		}
		bvisited = new boolean[C+1];
		
		bfs(1); //너비 우선 탐색 시작.
		System.out.println(cnt);
	} 

	public static void bfs(int idx) {
		q.add(idx); //시작할때 idx를 큐에 담아줌.
		bvisited[idx] = true; //이미 감염된 것은 true.
		while(!q.isEmpty()) { //비어있으면 시작X 비어있지않다면 동작 O
			int tmp = q.poll(); //시작할때 큐에있는 맨처음의 수를 빼주고
			for(int i = 1; i<=C; i++) { //거기에 해당하는 것을 검사함.
				if(com[tmp][i] == 1 && !bvisited[i]) {
					q.add(i);
					bvisited[i]= true;
					cnt++;
				}
			}
		}	
	}
}