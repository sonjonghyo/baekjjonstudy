import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			long start = 1;
			long end = 200000000;
			long result = 0;
			while(start <= end) {
				long mid = (start + end) / 2;
				long sum = mid * (mid+1) / 2;
				if(sum <= N) {
					result = Math.max(mid, result);
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}
			System.out.println(result);
		}
	}
}