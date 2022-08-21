import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double n = 1;
	static double m = 1;
	static double sum = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			pacto(N,M);
			System.out.printf("%.0f\n",sum);
		}
	}
	public static void pacto(int a, int b) {
		n = 1;
		m = 1;
		sum = 0;
		for(int i = a; i>0 ; i--) { 
			n *= i;
		}
		for(int i = b; i>0; i--) {
			m *= i;
		}
		double minus = b-a;
		if(minus ==0) {
			minus = 1;
		}
		for(double i = minus-1; i>0; i--) {
			minus *= i;
		}
		sum = m/(n*minus);
	}
}