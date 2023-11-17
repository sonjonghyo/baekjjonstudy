
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			cnt = N/50000;
			sb.append(cnt).append(" ");
			if(cnt != 0) {
				N -= (cnt * 50000);
			}
			cnt = N/10000;
			sb.append(cnt).append(" ");
			if(cnt != 0) {
				N -= (cnt * 10000);
			}
			cnt = N/5000;
			sb.append(cnt).append(" ");
			if(cnt != 0) {
				N -= (cnt * 5000);
			}
			cnt = N/1000;
			sb.append(cnt).append(" ");
			if(cnt != 0) {
				N -= (cnt * 1000);
			}
			cnt = N/500;
			sb.append(cnt).append(" ");
			if(cnt != 0) {
				N -= (cnt * 500);
			}
			cnt = N/100;
			sb.append(cnt).append(" ");
			if(cnt != 0) {
				N -= (cnt * 100);
			}
			cnt = N/50;
			sb.append(cnt).append(" ");
			if(cnt != 0) {
				N -= (cnt * 50);
			}
			cnt = N/10;
			sb.append(cnt).append(" ");
			if(cnt != 0) {
				N -= (cnt * 10);
			}
			if(tc != T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}