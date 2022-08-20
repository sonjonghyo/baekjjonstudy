import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i = 1; i<=Math.sqrt(N); i++) { //N의 제곱근까지만 올라감. (그 이상은 이전수에서 다 만들어짐)
			for(int j = i; i*j<=N; j++) { //j를  i부터 시작해야 이전에 만들었던것과 안겹칠수 있음.
				count++;
			}
		}
		System.out.println(count);
	}

}
