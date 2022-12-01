import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<Integer> num = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num.add(Integer.parseInt(st.nextToken()));
		}
		Integer[] result = num.toArray(new Integer[0]);
		Arrays.sort(result);
		for(int i = 0; i<result.length; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}