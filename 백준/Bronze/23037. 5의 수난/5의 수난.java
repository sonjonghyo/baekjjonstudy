import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int one = N/10000;
		N = N-one*10000;
		int two = N/1000;
		N = N-two*1000;
		int three = N/100;
		N = N-three*100;
		int four = N/10;
		int five = N%10;
		one = (int)Math.pow(one, 5);
		two = (int)Math.pow(two, 5);
		three = (int)Math.pow(three, 5);
		four = (int)Math.pow(four, 5);
		five = (int)Math.pow(five, 5);
		int result = one + two + three + four + five;
		System.out.println(result);
	}
}