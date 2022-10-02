import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int arr[] = new int[101];
			for(int i =0; i<3; i++) {
				arr[sc.nextInt()]++;
			}
			
			for(int i = 0; i<101; i++) {
				if(arr[i]%2==1) {
					sb.append(i);
					break;
				}
			}
			if(tc!=T)
				sb.append("\n");
			
		}
		System.out.println(sb);
		sc.close();
	}
}