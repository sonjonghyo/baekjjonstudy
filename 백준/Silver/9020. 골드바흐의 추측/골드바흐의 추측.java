import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int T;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[1000001];
		Arrays.fill(arr, 1);
		T = Integer.parseInt(br.readLine());
		sosu();
		for(int tc = 0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 2; i < n; i++) {
				if (arr[i] == 0)
					continue;
				int k = n - i;
				if (arr[k]==1 && i<=k) {
					sb.delete(0, sb.length());
					sb.append(i).append(" ").append(k).append("\n");
					continue;
				}
			}
			result.append(sb);
			}
		System.out.println(result);
	}

	public static void sosu() { //먼저 소수를 구해줌.
		for (int i = 2; i <= Math.sqrt(10000); i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i + i; j <= 10000; j += i)
				arr[j] = 0;
		}
	}
}