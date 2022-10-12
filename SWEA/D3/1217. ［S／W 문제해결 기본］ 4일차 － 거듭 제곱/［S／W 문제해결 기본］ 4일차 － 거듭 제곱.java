import java.util.Scanner;

public class Solution {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=10; tc++) {
			int T = sc.nextInt();
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			int M = sc.nextInt();
			int result = pow(M);
			sb.append(result);
			if(tc!=10)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	public static int pow(int M) { 
		if(M==0) {
			return 1;			
		}else {
			return N * pow(M-1);
		}
		
	}
}