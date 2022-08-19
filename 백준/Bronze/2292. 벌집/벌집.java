import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long result = 1;
		long len = 1;
		int cnt = 1;
		while (true) {
			if (N == 1) {
				break;
			}
			len += (6 * cnt);
			cnt++;
			if (N <= len) {
				result = cnt;
				break;
			}
		}
		System.out.println(result);
	}
}
