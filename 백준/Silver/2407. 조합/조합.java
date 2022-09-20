import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main { //BigInteger를 사용해서 풀어야함.
	static BigInteger result;
	static BigInteger di; //나눠줄 수(m팩토리얼을 계산)
	static int n;
	static int m;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num(n,m);
		di = pacto(m);
		System.out.println(result.divide(di));
	}
	public static BigInteger pacto(int i) { //m!을 계산할 식
		if(i<=1) {
			return BigInteger.valueOf(1);
		}
		return BigInteger.valueOf(i).multiply(pacto(i-1));
	}
	public static void num(int n, int m) { //n!/(n-m)!을 계산하는 식.
		long num = n-m;
		result = BigInteger.valueOf(1);
		for(int i = n; i>num; i--) {
			BigInteger a = new BigInteger(String.valueOf(i));
			result=result.multiply(a);
		}
	}
}