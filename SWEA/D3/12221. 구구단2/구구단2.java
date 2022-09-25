import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if(A > 9 || B > 9) {
				System.out.println("#" + tc + " " + -1);
			}else {
				System.out.println("#" + tc + " " + A*B);
			}
		}
	}
}