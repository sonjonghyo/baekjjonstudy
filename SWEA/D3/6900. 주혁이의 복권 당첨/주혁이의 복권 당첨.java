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
			String num[] = new String[N];
			int good[] = new int[N]; 
			for(int i = 0; i<N; i++) {
				String s = sc.next();
				int price = sc.nextInt();
				num[i] = s;
				good[i] = price;
			}
			int sum = 0;
			for(int i = 0; i<M; i++) {
				String s = sc.next();
				int max = 0;
				for(int j = 0; j<N; j++) {
					for(int k = 0; k<8; k++) {
						if(num[j].charAt(k)=='*')
							continue;
						if(num[j].charAt(k)==s.charAt(k)) {
						}else {
							break;
						}
						if(k==7) {
							if(max < good[j])
								max = good[j];
						}
					}		
				}
				sum += max;
			}
			sb.append(sum);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}