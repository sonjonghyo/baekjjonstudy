import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = sc.next();
			String s1 = sc.next();
			BigInteger a = new BigInteger(s);
			BigInteger b = new BigInteger(s1);
			a = a.add(b);
			sb.append(a.toString());
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}