import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int arr[];
	static int N,K;
	static int max;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			K = sc.nextInt();
			max = 0;
			arr = new int[N];
			visited = new boolean[N];
			for(int i = 0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
 			Arrays.sort(arr);
 			for(int i = arr.length-1; i>=arr.length-K; i--) {
 				max += arr[i];
 			}
 			sb.append(max);
 			if(tc!=T)
 				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}