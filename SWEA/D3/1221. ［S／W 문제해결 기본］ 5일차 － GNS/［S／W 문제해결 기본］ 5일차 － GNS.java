import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			String start = sc.next();
			sb.append(start);
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i = 0; i<N; i++) {
				String s = sc.next();
				switch(s) {
				case "ZRO" :
					arr[i] = 0;
					break;
				case "ONE" :
					arr[i] = 1;
					break;
				case "TWO" :
					arr[i] = 2;
					break;
				case "THR" :
					arr[i] = 3;
					break;
				case "FOR" :
					arr[i] = 4;
					break;
				case "FIV" :
					arr[i] = 5;
					break;
				case "SIX" :
					arr[i] = 6;
					break;
				case "SVN" :
					arr[i] = 7;
					break;
				case "EGT" :
					arr[i] = 8;
					break;
				case "NIN" :
					arr[i] = 9;
					break;
				}
			}
			Arrays.sort(arr);
			for(int i = 0; i<N; i++) {
				switch(arr[i]) {
				case 0 :
					sb.append(" ").append("ZRO");
					break;
				case 1 :
					sb.append(" ").append("ONE");
					break;
				case 2 :
					sb.append(" ").append("TWO");
					break;
				case 3 :
					sb.append(" ").append("THR");
					break;
				case 4 :
					sb.append(" ").append("FOR");
					break;
				case 5 :
					sb.append(" ").append("FIV");
					break;
				case 6 :
					sb.append(" ").append("SIX");
					break;
				case 7 :
					sb.append(" ").append("SVN");
					break;
				case 8 :
					sb.append(" ").append("EGT");
					break;
				case 9 :
					sb.append(" ").append("NIN");
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