import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long result = 0;
	static int n;
	static int m;
	static final int P = 1000000007;

	// 중간에 범위를 벗어날수 있기때문에 연산할때마다 P를 나누어 주어야한다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		// 구하고 싶은것 n! / (n-r)!*r!
		long factorial[] = new long[n + 1];
		factorial[0] = 1;
		factorial[1] = 1;
		for (int i = 2; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i % P; // 얘도 벗어날수 있기때문에 factorial곱할때 P를 나누어줌.
		}
		// 일일이 계산하는것보다 범위내의 팩토리얼의 수를 저장
		long ans = factorial[n] * pow(factorial[n - m] * factorial[m] % P, P - 2) % P;
		System.out.println(ans);
	}

	public static long pow(long N, long M) {
		if (M == 1)
			return N;

		if (M % 2 == 0) {
			result = pow(N, M / 2);
			return result * result % P;
		} else {
			result = pow(N, (M - 1) / 2);
			return result * result % P * N % P;
		}
	}
}