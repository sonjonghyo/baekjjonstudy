import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum[] = new int[10];
		int score[] = new int[10];
		int com1 = 0;
		int com2 = 0;
		int result = 0;
		for(int i = 0; i<10; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		sum[0] = score[0];
		for(int i = 1; i<10; i++) {
			sum[i] = sum[i-1] + score[i];
			if(sum[i] == 100) {
				System.out.println(sum[i]);
				break;
			}else if(sum[i] > 100) {
				com1 = Math.abs(sum[i]-100);
				com2 = Math.abs(sum[i-1] - 100);
				result = Math.min(com1, com2);
				if(result == com1) {
					System.out.println(sum[i]);
				}else {
					System.out.println(100-result);
				}
				break;
			}else {
				if(i==9)
					System.out.println(sum[i]);
			}
		}
	}
}