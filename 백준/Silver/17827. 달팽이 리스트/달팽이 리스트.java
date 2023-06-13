import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int Cn[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			Cn[i] = Integer.parseInt(st.nextToken());
		}
		int cycle = N - V + 1;
		for(int i = 0; i < M; i++) {
			int K = Integer.parseInt(br.readLine());
			if(K < N) {
				sb.append(Cn[K]);
			}else {
				int tmp = K - N;
				sb.append(Cn[tmp%cycle+V-1]);
			}
			if(i != M-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}