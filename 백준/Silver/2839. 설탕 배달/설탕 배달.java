import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0; // 몫과 나머지의 합을 구할것
		while(true) {
			if(N%5==0) {
				sum += N/5;
				System.out.println(sum);
				break;
			}else {
				N -= 3;
				sum++;
			}
			if(N<0) {
				System.out.println(-1);
				break;
			}
		}
	}
}