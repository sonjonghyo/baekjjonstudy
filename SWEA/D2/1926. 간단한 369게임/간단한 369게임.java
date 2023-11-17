import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= N; i++) {
			String S = String.valueOf(i);
			int cnt = 0;
			for(int j = 0; j < S.length(); j++) {
				if(S.charAt(j) == '3') {
					cnt++;					
				}else if(S.charAt(j) == '6') {
					cnt++;
				}else if(S.charAt(j) == '9') {
					cnt++;
				}
			}
			if(cnt == 0) {
				sb.append(i);
			}else {
				for(int j = 0; j < cnt; j++) {
					sb.append('-');
				}
			}
			if(i != N)
				sb.append(" ");
		}
		System.out.println(sb);
	}
}