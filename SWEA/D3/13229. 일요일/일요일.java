import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = sc.next();
			switch(s) {
			case "MON" :
				sb.append(6);
				break;
			case "TUE" :
				sb.append(5);
				break;
			case "WED" :
				sb.append(4);
				break;
			case "THU" :
				sb.append(3);
				break;
			case "FRI" :
				sb.append(2);
				break;
			case "SAT" :
				sb.append(1);
				break;
			case "SUN" :
				sb.append(7);
				break;
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}