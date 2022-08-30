import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//파스칼을 2차원 배열로 생각을 해주어서
	//처음위치는 1,1로 시작해서 좌표값으로 생각해 주었습니다.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int pascal[][] = new int[n+2][n+2]; //n의 크기보다 2개 크게만들어 계산하기 쉽게 만들어주었습니다.
		pascal[0][0] = 1; //0,0 을 1로주어 시작값을 정해주었습니다.
		for(int i = 1; i<pascal.length-1; i++) { //i는 파스칼의 삼각형이 원래 만들어질수있는 크기까지 해서 배열의길이-1로 해주었으며
			for(int j = 1; j<=i+1; j++) { //j는 i+1까지만 파스칼의 삼각형의 특징을 이용하여 그 줄에는 i의 값보다 하나 큰수까지만 동작하게해주었습니다.
				pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j]; //현재 나의 위치의 값은 대각선왼쪽의 값+내 바로위의 값을 더해준 값을 넣어줍니다.
			}
		}
		System.out.println(pascal[n][k]); //1,1부터 시작해주었기때문에 n,k가 내 좌표값이므로 그대로 출력해줍니다.	
	}
}