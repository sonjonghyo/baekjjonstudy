import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int sum = 0;
			int score;
			for(int i = 0; i<5; i++) {
				score = sc.nextInt();
				if(score<40) {
					sum += 40;
				}else {
					sum += score;
				}
			}
			int result = sum/5;
			sb.append(result);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}