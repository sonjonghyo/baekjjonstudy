import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			int t = sc.nextInt();
			sb.append("#").append(t).append(" ");
			String com = sc.next();
			int clength = com.length();
			String original = sc.next();
			int cnt;
			int result = 0;
			for(int i = 0; i<original.length(); i++) {
				cnt = 0;
				for(int j = 0; j<clength; j++) {
					if(i+j>=original.length())
						break;
					if(original.charAt(i+j)==com.charAt(j)) {
						cnt++;
					}else {
						break;
					}
				}
				if(cnt==clength)
					result++;
			}
			sb.append(result);
			if(tc!=10)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}