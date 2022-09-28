import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static int p[];
	static int edges[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int V = sc.nextInt();
			int E = sc.nextInt();
			edges = new int[E][3];
			
			for(int i = 0; i<E; i++) {
				edges[i][0] = sc.nextInt();
				edges[i][1] = sc.nextInt();
				edges[i][2] = sc.nextInt();
			}
			//크루스칼을 하기위해선 가중치를 정렬해야함
			Arrays.sort(edges, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] -  o2[2];
				}
			});
			
			p = new int[V+1]; //대표를 저장할 배열
			for(int i = 1; i<=V; i++) {
				makeSet(i);
			}
			
			long ans = 0;
			int pick = 0;
			//간선 선택.
			for(int i = 0; i<E; i++) {
				int px = findSet(edges[i][0]);
				int py = findSet(edges[i][1]);
				
				if(px != py) { //대표가 같으면 패스 다르면 union해줌.
					union(px,py);
					ans += edges[i][2];
					pick++;
				}
				
				if(pick==V-1) break;
			}
			sb.append(ans);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void union(int x, int y) {
		p[y] = x; //합쳐주기.
		
	}
	private static int findSet(int i) {
		if(i!=p[i]) //현재 i와 p[i]의 값이 다르다? 대표자가 달라?
			p[i] = findSet(p[i]); //대표자를 찾아 나선다.
		return p[i]; //대표자와 i랑 같으면 p[i]를 리턴해줌.
	}
	private static void makeSet(int i) {
		p[i] = i; //먼저 나 자신을 대표로 초기화해줌.
	}
}