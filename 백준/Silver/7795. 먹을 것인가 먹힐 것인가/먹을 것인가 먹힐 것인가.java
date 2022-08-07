import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int A,B;
		int T;
		T = Integer.parseInt(br.readLine());
		for(int i = 1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			int cnt = 0;
			int arra[] = new int[A];
			int arrb[] = new int[B];
			
			st = new StringTokenizer(br.readLine());
			for(int a = 0; a<A; a++) {
				arra[a] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int b = 0; b<B; b++) {
				arrb[b] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arrb);
			for(int x : arra) {
				for(int y : arrb) {
					if(x <= y) {
						break;
					} else {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}