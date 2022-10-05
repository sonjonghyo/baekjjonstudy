import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = sc.next();
			int arr[] = new int[s.length()+1];
			int H = sc.nextInt();
			String result = "";
			for(int i = 0; i<H; i++) {
				arr[sc.nextInt()]++;
			}
			for(int i = 0; i<s.length(); i++) {
				if(arr[i]!=0) {
					for(int j = 0; j<arr[i]; j++) {
						result += "-";
					}
				}
				result += s.charAt(i);
			}
			if(arr[s.length()]!=0) {
				for(int i = 0; i<arr[s.length()]; i++) {
					result += "-";
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