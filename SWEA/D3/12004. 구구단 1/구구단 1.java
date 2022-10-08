import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			boolean flag = false;
			for(int i = 1; i<=9; i++) {
				if(N%i==0) {
					int a = N/i;
					if(a < 10) {
						flag = true;
						break;
					}
				}
			}
			if(flag) {
				sb.append("Yes");
			}else {
				sb.append("No");
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}