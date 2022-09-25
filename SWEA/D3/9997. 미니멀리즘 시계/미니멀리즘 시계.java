import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			int H = 0;
			int S = 0;
			S = N*2;
			if(S>=60) {
				H = S/60;
				S %= 60;
			}
			System.out.println("#" + tc + " " + H + " " + S);
		}
		sc.close();
	}
}