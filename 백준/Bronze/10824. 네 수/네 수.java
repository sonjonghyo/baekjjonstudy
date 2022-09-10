import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String arr[] = new String[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
			arr[i] = st.nextToken();
		}
		String num1 = arr[0] + arr[1];
		String num2 = arr[2] + arr[3];
		long n1 = Long.parseLong(num1);
		long n2 = Long.parseLong(num2);
		long result = n1+n2;
		System.out.println(result);
	}
}