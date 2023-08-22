import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int cnt;
		int cur;
		public Node(int cnt, int cur) {
			this.cnt = cnt;
			this.cur = cur;
		}
	}
	static Queue<Node> q;
	static boolean visited[] = new boolean[100001];
	static int A,B,N,M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); //스카이 콩콩 A의 힘.
		B = Integer.parseInt(st.nextToken()); //스카이 콩콩 B의 힘.
		N = Integer.parseInt(st.nextToken()); //동규의 위치.
		M = Integer.parseInt(st.nextToken()); //주미의 위치.
		q = new LinkedList<>();
		q.add(new Node(0, N));
		int answer = 0;
		answer = searchB();
		System.out.println(answer);
	}
	private static int searchB() {
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.cur == M) {
				return n.cnt;
			}
			if(n.cur + 1 <= 100000 && !visited[n.cur + 1]) {
				visited[n.cur + 1] = true;
				q.add(new Node(n.cnt + 1, n.cur + 1));
			}
			if(n.cur - 1 >= 0 && !visited[n.cur - 1]) {
				visited[n.cur - 1] = true;
				q.add(new Node(n.cnt + 1, n.cur - 1));
			}
			if(n.cur + A <= 100000 && !visited[n.cur + A]) {
				visited[n.cur + A] = true;
				q.add(new Node(n.cnt + 1, n.cur + A));
			}
			if(n.cur - A >= 0 && !visited[n.cur - A]) {
				visited[n.cur - A] = true;
				q.add(new Node(n.cnt + 1, n.cur - A));
			}
			if(n.cur + B <= 100000 && !visited[n.cur + B]) {
				visited[n.cur + B] = true;
				q.add(new Node(n.cnt + 1, n.cur + B));
			}
			if(n.cur - B >= 0 && !visited[n.cur - B]) {
				visited[n.cur - B] = true;
				q.add(new Node(n.cnt + 1, n.cur - B));
			}
			if(n.cur * A <= 100000 && !visited[n.cur * A]) {
				visited[n.cur * A] = true;
				q.add(new Node(n.cnt + 1, n.cur * A));
			}
			if(n.cur * B <= 100000 && !visited[n.cur * B]) {
				visited[n.cur * B] = true;
				q.add(new Node(n.cnt + 1, n.cur * B));
			}
		}
		return 0;
	}
}