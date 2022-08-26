import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			BigInteger big = new BigInteger(s);
			if(big.remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
				//remainder는 BigInteger의 나머지를구하는 함수
				//처음에 big을 2로 나누어 주고
				//그다음에 0인지 비교해서 참이면 even 거짓이면 odd출력
				System.out.println("even");
			}else {
				System.out.println("odd");
			}
		}
	}
}