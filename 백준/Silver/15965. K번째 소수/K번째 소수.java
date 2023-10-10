import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int count = 0;
		int answer = 0;
		for(int i = 2; i <= 500000; i++) {
			if(check(i)) {
				count++;
			}
			if(count == K) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

	private static boolean check(int i) {
		for(int a = 2; a * a <= i; a++) {
			if(i%a == 0) {
				return false;
			}
		}
		return true;
	}
}