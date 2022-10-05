import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int D = sc.nextInt();
			int H = sc.nextInt();
			int M = sc.nextInt();
			
			int rd = D-11;
			int rh = H-11;
			int rm = M-11;
			
			int sum = 0;
			if(rd <= 0 && rh < 0 && rm < 0) {
				sb.append(-1);
			}else {
				sum += (rd*24*60);
				sum += (rh*60);
				sum += rm;
				if(sum < 0) {
					sb.append(-1);
				}else {
					sb.append(sum);					
				}
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}