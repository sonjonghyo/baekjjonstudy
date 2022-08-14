import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		if(N==4 || N==7) {
			sum = -1;
		}else if((N%5)==1 || N%5==3) {
			sum = (N/5)+1;
		}else if((N%5)==2|| (N%5)==4) {
			sum = (N/5)+2;
		}else if(N%5 == 0) {
			sum = N/5;
		}
		System.out.println(sum);
	}
}