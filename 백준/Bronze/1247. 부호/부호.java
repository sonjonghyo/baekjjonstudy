import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<=3; tc++) {
			BigInteger sum = new BigInteger("0"); //수가 커서 BigInteger로 선언해주어야한다.
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i<N; i++) {
				BigInteger num = new BigInteger(br.readLine());
				sum = sum.add(num);
			}
			if(sum.compareTo(BigInteger.ZERO) == 0) { //sum이 0이라면
				System.out.println(0); //0을 출력
			}else if(sum.compareTo(BigInteger.ZERO) == 1) { //0과 비교했을때 크다면 (크면 1이나옴). 
				System.out.println("+");
			}else {
				System.out.println("-");
			}
		}
	}
}