import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int a,b,n,m;
	static int human[][];
	static int degree[]; //촌수를 넣어줄 배열
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); //사람의 수
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()); //촌수를 계산해야하는 서로 다른 두사람의 번호.
		b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		human = new int[n+1][n+1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			human[x][y] = 1; //인접행렬로 서로 1로 만들어줍니다.
			human[y][x] = 1;
		}
		degree = new int[n+1];
		bfs(a, b); //1촌이므로 1로 계산.
		if(degree[b] == 0) { //촌수 계산을 못했다면?
			System.out.println(-1);
		}else { //촌수가 있다면.
			System.out.println(degree[b]);
		}
	}
	private static void bfs(int s, int e) {
		Queue<Integer> search = new LinkedList<>(); //탐색을 위한 큐 생성
		search.add(s); //시작지점을 큐에 넣어줍니다.
		while(!search.isEmpty()) { //다 빌때까지 확인
			int q = search.poll(); //큐에있는걸 빼주고
			if(q == e) { //만나면 while문을 끝내줍니다.
				break;
			}
			for(int i = 1; i <= n; i++) { //1번부터 넣어줬으므로 1부터 n까지 확인해보기.
				if(human[q][i] == 1 && degree[i] == 0) { //둘이 이어져있으며 아직 촌수 확인을 안했다면?
					degree[i] = degree[q] + 1; //현재 촌수에서 1씩 더해줌.
					search.add(i);
				}
			}
		}
	}
}