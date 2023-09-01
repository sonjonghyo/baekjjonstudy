import java.io.*;

public class Main {
	static boolean flag = true;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				star(i, j, N);
				if(flag) {
					sb.append("*");
				}else {
					sb.append(" ");
				}
			}
			if(i != N-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void star(int x, int y, int N) {
		if((x / N) % 3 == 1 && (y/N) % 3 == 1) {
			flag = false;
		}else {
			if(N / 3 == 0) {
				flag = true;
			}else {
				star(x,y,N/3);
			}
		}
	}
}