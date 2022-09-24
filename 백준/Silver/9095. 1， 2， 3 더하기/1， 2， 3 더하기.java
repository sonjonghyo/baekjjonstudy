import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	//규칙을 찾아보니 1은 1번 만들수있고 2는 2번 3은 4번만들수있다.
	//그 아래의 수는 하나씩 1,2,3더하기이므로 현재의 i-3, i-2, i-1 3개를 더해서 만들수있다. 테스트케이스가 11보다 작다했으니
	//먼저 10까지의 누적합을 전부 구해놓고 테스트케이스마다 하나씩 뽑아쓰는 걸로 풀이를 생각했다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int num[] = new int[11]; //1~10까지의 누적합을 넣어줄 배열
		num[1] = 1;
		num[2] = 2;
		num[3] = 4;
		for(int i = 4; i<=10; i++) //3까지는 구해져있으므로 4부터 넣어주고
				num[i] += num[i-1]+num[i-2]+num[i-3];
		for(int tc = 1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(num[n]);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}