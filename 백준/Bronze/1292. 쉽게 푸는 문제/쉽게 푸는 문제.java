import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[] = new int[1001];
		int plus = 1;
		int cnt = 0;
		for(int i = 1; i<=1000; i++) {
			cnt++;
			arr[i] = plus;
			if(cnt==plus) {
				plus++;
				cnt = 0;
			}
		}
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		long sum = 0;
		for(int i = A; i<=B; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}