import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			if(N%2==0) {
				sb.append("Alice");
			}else {
				sb.append("Bob");
			}
			if(tc!=T)
				sb.append("\n");	
		}
		System.out.println(sb);
		sc.close();
	}
}