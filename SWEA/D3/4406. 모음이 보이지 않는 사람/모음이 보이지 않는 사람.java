import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = sc.next();
			for(int i = 0; i<s.length(); i++) {
				if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
					continue;
				sb.append(s.charAt(i));
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}