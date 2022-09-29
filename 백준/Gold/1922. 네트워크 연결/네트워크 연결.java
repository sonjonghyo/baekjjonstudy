import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int p[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //정점의 개수
		int M = Integer.parseInt(br.readLine()); //간선의 개수
		int com[][] = new int[M][3];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			com[i][0] = Integer.parseInt(st.nextToken());
			com[i][1] = Integer.parseInt(st.nextToken());
			com[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(com, new Comparator<int[]>() { //가중치에 대해서 정렬을 먼저 해준다.
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		p = new int[N+1];
		for(int i = 1; i<=N; i++) { //makeSet 사용부분.
			p[i] = i;
		}
		int pick = 0;
		int ans = 0;
		
		for(int i = 0; i<M; i++) {
			int px = findSet(com[i][0]);
			int py = findSet(com[i][1]);
			
			if(px!=py) { //유니온 (대표자가 다를경우 대표자를 하나로 만들어줌.)
				union(px,py); 
				ans += com[i][2]; //가중치를 더해준다.
				pick++; //한번 뽑았음을 알려줌.
			}
			if(pick == N-1) //뽑은횟수가 정점-1이면 더이상 뽑아도 의미가없어서 break를 걸어줌.
				break;
		}	
		System.out.println(ans);
	}
	private static void union(int x, int y) {
		p[y] = x;
	}
	private static int findSet(int i) {
		if(i!=p[i])
			return findSet(p[i]);
		return p[i];
	}
}