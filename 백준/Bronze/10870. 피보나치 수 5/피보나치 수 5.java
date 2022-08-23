import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(pibo(n));
	}
	public static int pibo(int n) { //피보나치의 수 함수
		if(n==0) { //0일때는 0을 출력
			return 0;
		}else if(n==1) { //1일 때는 1을 출력
			return 1;
		}else { //2이상이라면
			return pibo(n-2)+pibo(n-1); //n에 -2, -1해준 함수를 더해주고 리턴해준다.
		}
	}
}
