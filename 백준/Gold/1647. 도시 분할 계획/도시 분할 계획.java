import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//크루스칼 방식 사용.
public class Main { 
	static int p[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수 
		
		int edges[][] = new int[M][3];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken()); //시작정점
			edges[i][1] = Integer.parseInt(st.nextToken()); //도착정점
			edges[i][2] = Integer.parseInt(st.nextToken()); //가중치
		}
		
		Arrays.sort(edges, new Comparator<int[]>() { //가중치 오름차순으로 정렬.

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
			
		});
		
		p = new int[N+1]; //대표를 저장해줄 친구.
		for(int i = 1; i<=N; i++) {
			p[i] = i; //나 자신을 대표로 먼저 초기화.
		}
		int pick = 0;
		int dis = 0;
		for(int i = 0; i<M; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);
			
			if(px != py) {
				union(px,py);
				dis += edges[i][2];
				pick++;
			}
			if(pick==N-2) break;
		}
		System.out.println(dis);
		
	}
	private static void union(int x, int y) {
		p[y] = x;
		
	}
	private static int findSet(int i) {
		if(i != p[i])
			p[i] = findSet(p[i]);
		return p[i];
	}
	
}