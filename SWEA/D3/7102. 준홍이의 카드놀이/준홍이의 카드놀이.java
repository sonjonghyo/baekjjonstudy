import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc);
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int arr[] = new int[N+M+1];
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					int sum = i;
					sum += j;
					arr[sum]++;
				}
			}
			int max = 0;
			String result = "";
			for(int i = 1; i<arr.length; i++) {
				if(max < arr[i]) {
					max = arr[i];
					result = " "+i;
				}else if(max == arr[i]) {
					result += " "+i;
				}
			}
			sb.append(result);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}