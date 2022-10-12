import java.util.Scanner;

public class Solution {
	static StringBuilder com = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int A = sc.nextInt();
			int B = sc.nextInt();
			int cnt = 0;
			for(int i = A; i<=B; i++) {
				boolean flag1 = false;
				boolean flag2 = false;
				flag1 = reverse(i);
				if(((int)Math.sqrt(i)*(int)Math.sqrt(i))==i) {
					flag2 = reverse((int)Math.sqrt(i));					
				}else {
					continue;
				}
				if(flag1 && flag2) {
					cnt++;
				}	
			}
			sb.append(cnt);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	public static boolean reverse(int i) {
		String aa = String.valueOf(i);
		com.append(aa);
		com.reverse();
		char result[] = new char[aa.length()];
		com.getChars(0, aa.length(), result, 0);
		boolean flag = false;
		for(int k = 0; k<aa.length(); k++) {
			if(result[k]!=aa.charAt(k)) 
				break;						
			if(k==aa.length()-1)
				flag = true;
			
		}
		if(flag) {
			return true;			
		}else {
			return false;
		}
	}
}