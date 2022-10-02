import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
        sc.nextLine();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = sc.nextLine();
			String result = "";
			s = s.toUpperCase();
			for(int i = 0; i<s.length(); i++) {
				if(i==0) 
					result += s.charAt(i);
				if(s.charAt(i)==' ') {
					if(i+1<s.length())
						result += s.charAt(i+1);
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