import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int N = sc.nextInt();
			for(int i = 0; i<N; i++) {
				int num = sc.nextInt();
				if(max < num)
					max = num;
				if(min > num)
					min = num;
			}
			sb.append(min).append(" ").append(max);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}