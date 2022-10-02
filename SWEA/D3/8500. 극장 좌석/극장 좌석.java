import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int sum = 0;
			int arr[] = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			for(int i = N-1; i>=0; i--) {
				if(i == N-1)
					sum += arr[i]*2+1; //정렬하여 맨 뒤부터 시작하니 맨 뒤의 빈칸개수*2 + 내자리를 해줌.
				else
					sum += arr[i]+1; //그 뒤부턴 내 앞만 보면되므로 내자리 + 내것 왼칸 빈칸개수 더해줌.
			}
			sb.append(sum); 
			
			if(tc!=T)
				sb.append("\n");
			
		}
		System.out.println(sb);
		sc.close();
	}
}