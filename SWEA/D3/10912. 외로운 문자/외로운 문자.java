import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = sc.next(); //소문자 a의 아스키코드는 97
			int arr[] = new int[26];
			for(int i = 0; i<s.length(); i++) {
				int c = s.charAt(i)-'a';
				if(arr[c]==0) {
					arr[c]++;
				}else {
					arr[c] = 0;
				}
			}
			int cnt = 0;
			for(int i = 0; i<26; i++) {
				if(arr[i]==1) {
					char a = (char)(i+'a');
					sb.append(a);
					cnt++;
				}
			}
			if(cnt==0)
				sb.append("Good");
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}