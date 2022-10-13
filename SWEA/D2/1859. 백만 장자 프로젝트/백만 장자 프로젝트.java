import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int value[] = new int[N];
			for(int i = 0; i<N; i++) {
				value[i] = sc.nextInt();
			}
			long result = 0;
			int maxvalue = 0;
			for(int i = N-1; i>=0 ;i--) {
				if(maxvalue < value[i]) 
					maxvalue = value[i];
				result += maxvalue - value[i];
			}
			sb.append(result);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}