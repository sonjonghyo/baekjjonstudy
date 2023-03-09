import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int idx;
		int important;
		public Node(int idx, int important) {
			this.idx = idx;
			this.important = important;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			Queue<Node> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Integer document[] = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				document[i] = Integer.parseInt(st.nextToken());
				q.add(new Node(i, document[i]));
			}
			Arrays.sort(document, Collections.reverseOrder());
			int cnt = 1;
			int idx = 0;
			while(true) {
				Node n = q.poll();
				if(document[idx] == n.important) {
					if(M == n.idx) {
						sb.append(cnt);
						break;
					}else {
						idx++;
						cnt++;
					}
				}else {
					q.add(n); //다르면 다시 큐에 넣어줘
				}
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}