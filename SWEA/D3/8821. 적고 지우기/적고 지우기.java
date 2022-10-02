import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = sc.next();
			int num[] = new int[10];
			for(int i = 0; i<s.length(); i++) {
				int a = s.charAt(i)-'0';
				if(num[a]==0) {
					num[a]=1;
				}else {
					num[a]=0;
				}	
			}
			int result = 0 ;
			for(int i = 0; i<10; i++) {
				if(num[i]==1)
					result++;
			}
			sb.append(result);
			if(tc!=T)
				sb.append("\n");
			
		}
		System.out.println(sb);
		sc.close();
	}
}