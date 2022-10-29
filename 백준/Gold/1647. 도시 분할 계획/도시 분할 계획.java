
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int st, ed, cost;
		
		public Edge(int st, int ed, int cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	static int max_w = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		
		List<Edge>[] adjList = new ArrayList[N+1]; //인접 리스트 생성.
		for(int i = 0; i<N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1; //시작지점
			int e = Integer.parseInt(st.nextToken())-1; //도착지점
			int w = Integer.parseInt(st.nextToken()); //가중치
			
			adjList[s].add(new Edge(s,e,w)); //시작지점에서 끝지점으로 가는 것 리스트에 추가.
			adjList[e].add(new Edge(e,s,w)); //끝지점에서 시작지점으로 가는 것 리스트에 추가.
		} //인접행렬 완성
		boolean visited[] =  new boolean[N+1]; //방문처리용.
		PriorityQueue<Edge> pq = new PriorityQueue<>(); //우선순위 큐 적용.
		//가중치가 낮은것 부터 시작하기위해 우선순위 큐 사용함.
		visited[0] = true;
		pq.addAll(adjList[0]);
		//1이 시작지점, 끝지점에 있는 것을 전부 담아줘.
		int pick = 1;
		int dis = 0;
		while(pick < N) {
			Edge edge = pq.poll();
			if(visited[edge.ed]) continue; //이미 도착했던곳이면 다음.
			
			visited[edge.ed] = true; //현재 시작->도착은 방문되었으니 true로 변경.
			max_w = Math.max(max_w, edge.cost);
			dis += edge.cost; //가중치를 거리에 추가시키고
			pq.addAll(adjList[edge.ed]); //도착지점에 해당하는 부분 모두 리스트에 담아주기.
			pick++;
		}
		System.out.println(dis-max_w);
	}
}