import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int ap, dis;
		public Edge(int ap, int dis) {
			this.ap = ap;
			this.dis = dis;
		}
	}
	static long answer = 0;
	static int N;
	static List<Edge>[] li;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		//방문 처리할 boolean배열 생성
		visited = new boolean[N+1];
		//인접 리스트 생성
		li = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			li[i] = new ArrayList<>();
		}
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			//a에서 b로 갈수있고 거리 c저장
			li[a].add(new Edge(b,c));
			//b에서 a로 갈수있고 거리 c저장.
			li[b].add(new Edge(a,c));
		}
		//시작지점을 true로 만들고
		visited[1] = true; 
		search(1,0);
		System.out.println(answer);
	}
	//현재의 위치 point와 지금까지의 거리 sumdis
	private static void search(int point , long sumdis) {
		if(answer < sumdis)
			answer = sumdis;
		
		//인접리스트 배열에서 내 현재 위치에서 갈수 있는 부분만 뽑아내기.
		for(Edge next : li[point]) {
			//이미 방문한 도착지점이라면 continue사용.
			if(visited[next.ap]) continue;
			//방문 안했다면 true로 변경 후
			visited[next.ap] = true;
			//dfs로 다음 지점을 point로 바꾸고 거리는 현재 거리 + 다음 거리 저장.
			search(next.ap, sumdis + next.dis);
		}
		
	}
}