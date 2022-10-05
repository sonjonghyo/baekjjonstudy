import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int sum = 0;
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				sum += arr[i];
			}
			int avg = sum/N;
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				if(arr[i]>avg) {
					cnt += arr[i]-avg;
				}
			}
			sb.append(cnt);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}