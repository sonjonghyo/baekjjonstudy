
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int result = 0; //얼마나 운동을 더해야하는지 출력해주는 변수.
			if(X<L) {
				result = L-X;
			}else if(X>=L && X<=U) {
				result = 0;
			}else {
				result = -1;
			}
			sb.append(result);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}