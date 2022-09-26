import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			String s = sc.next();
			int a = 1;
			int b = 1;
			for(int i = 0; i<s.length(); i++) {
				if(s.charAt(i)=='L') {
					b = a + b;
				}else {
					a = a + b;
				}
			}
			System.out.println("#"+tc+" "+a+" "+b);
		}
		sc.close();
	}
}