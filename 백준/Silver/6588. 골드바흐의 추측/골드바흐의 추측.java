import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int T;
	static int arr[];
	static boolean check = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[1000001];
		Arrays.fill(arr, 1);
		sosu();
		while (true) {
			check = false;
			T = Integer.parseInt(br.readLine());
			if (T == 0)
				break;
			for (int i = 2; i < T; i++) {
				if (arr[i] == 0)
					continue;
				int k = T - i;
				if (arr[k]==1) {
					sb.append(T).append(" = ").append(i).append(" + ").append(k).append("\n");
					check = true;
					break;
				}
			}
			if (!check) {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
	public static void sosu() {
		for (int i = 2; i <= Math.sqrt(1000000); i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i + i; j <= 1000000; j += i)
				arr[j] = 0;
		}
	}

}