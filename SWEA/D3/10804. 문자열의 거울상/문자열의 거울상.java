import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = sc.next();
			String result = "";
			for(int i = s.length()-1; i>=0; i--) {
				char a = s.charAt(i);
				switch(a) {
				case 'b':
					result += 'd';
					break;
				case 'd':
					result += 'b';
					break;
				case 'p':
					result += 'q';
					break;
				case 'q':
					result += 'p';
					break;
					default:
						break;
				}
			}
			sb.append(result);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}