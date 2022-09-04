import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int ev[];
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine()); //테스트케이스 개수
		for(int tc = 0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n][2]; //득점과 실점만 기록해줄것이므로 이렇게 기록.
			ev = new int[n];
			pigo(n, m);
			if(tc!=T-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void pigo(int n, int m) throws Exception{
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			arr[a-1][0] += p;
			arr[a-1][1] += q;
			arr[b-1][0] += q;
			arr[b-1][1] += p;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			int S = arr[i][0];
			int W = arr[i][1];
			ev[i] = (int)((Math.pow(S, 2)/(Math.pow(S, 2)+Math.pow(W, 2)))*1000);
			if(ev[i] > max)
				max = ev[i];
			if(ev[i] < min)
				min = ev[i];
		}
		sb.append(max).append("\n");
		sb.append(min);
	}
}