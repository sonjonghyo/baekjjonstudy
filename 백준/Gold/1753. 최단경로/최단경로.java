import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<Node> adjList[];
	static class Node implements Comparable<Node>{
		int v;
		long w;
		public Node(int v, long w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
		
	}
	static int V,E, K;
	static int arr[][];
	static boolean visited[];
	static long dist[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V+1];
		for(int i = 1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		dist = new long[V+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new Node(e,w));
		}
		dij(K);
		
		for(int i = 1; i<=V; i++) {
			if(i==K) {
				sb.append(dist[i]);				
			}else if(dist[i]==Long.MAX_VALUE) {
				sb.append("INF");
			}else {
				sb.append(dist[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
	private static void dij(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[V+1];
		pq.add(new Node(st,0));
		dist[st] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(visited[n.v])
				continue;
			visited[n.v] = true;
			
			for(Node node : adjList[n.v]) {
				if(!visited[node.v] && dist[node.v] > dist[n.v] + node.w) {
					dist[node.v] = dist[n.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
	}
}