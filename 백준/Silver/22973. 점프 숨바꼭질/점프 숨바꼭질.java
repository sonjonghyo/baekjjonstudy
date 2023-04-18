import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		long K = Long.parseLong(br.readLine());
		long power = 0;
		if(K == 0) {
			System.out.println(0);
		}else if(K%2 == 0){
			System.out.println(-1);
		}else {		
			power = (long)(Math.log(Math.abs(K)) / Math.log(2));
			System.out.println(power+1);
		}
	}
}