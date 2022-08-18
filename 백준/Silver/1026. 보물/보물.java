import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int A[] = new int [N];
		int B[] = new int [N];
		int rA[] = new int[N];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i = 0; i<N; i++) {
			rA[i] = A[A.length-1-i];
		}
		for(int i = 0; i<N; i++) {
			sum += (rA[i] * B[i]);
		}
		System.out.println(sum);
	}
}