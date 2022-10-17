import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;
		int pack[] = new int[M];
		int unit[] = new int[M];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			pack[i] = Integer.parseInt(st.nextToken());
			unit[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pack);
		Arrays.sort(unit);
		
		result = Math.min(((N/6) + 1) * pack[0], Math.min(N * unit[0], ((N/6) * pack[0]) + ((N%6) * unit[0])));
		System.out.println(result);
		
	}
}