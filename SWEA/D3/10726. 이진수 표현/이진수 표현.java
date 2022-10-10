import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			if(M%2==0) { //짝수이면 가장마지막인 1이 켜지지않기때문에 무조건 OFF
				sb.append("OFF");
			}else {
				for(int i = 0; i<N; i++) {
					if(M%2==0) {
						sb.append("OFF");
						break;
					}else {
						M /= 2;
					}
					if(i==N-1)
						sb.append("ON");
				}
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}