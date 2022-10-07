import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int pibo[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		pibo = new int[N+1];
			
		pibo[0] = 0;
		if(N>1) {
			pibo[1] = 1;			
		}
		int result = fibo(N);
		sb.append(result);
		System.out.println(sb);
	}
	
	public static int fibo(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;			
		}
		for(int i = 2; i<=n; i++) {
			pibo[i] = pibo[i-1] + pibo[i-2];
		}
		
		return pibo[n];
		
	}
}