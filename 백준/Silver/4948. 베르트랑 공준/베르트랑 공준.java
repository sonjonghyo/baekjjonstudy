import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int T;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0; //소수가 나온 횟수.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[246913]; //범위보다 1칸크게설정.(배열은0부터시작하므로)
		Arrays.fill(arr, 1); //전부 1로 바꾸어준다.
		sosu(); //소수판별 함수(에라토스테네스의 체)
		while (true) {
			cnt = 0;
			T = Integer.parseInt(br.readLine());
			if (T == 0) //0을만날시 while문을 끝낸다.
				break;
			for (int i = T+1; i <= T*2; i++) { //T보다 크고라고했으니 T+1을 주어 T를 포함시키지 않는다.
				if (arr[i] == 0) //0일때는 소수가아닌것이므로 다음수로 넘어간다.
					continue;
				if (arr[i]==1) { //1일때는 소수이므로 cnt를 1 증가시켜준다.
					cnt++;
				}
			}
			sb.append(cnt).append("\n"); //for문이끝나면 cnt를 stringBuilder에 추가시켜준다.
		}
		System.out.println(sb);
	}
	public static void sosu() {
		arr[0] = arr[1] = 0; //0과 1은 소수가 아니므로 0으로 만들어줌.
		for (int i = 2; i <= Math.sqrt(246912); i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i + i; j <= 246912; j += i) //범위는 n의범위가 123,456이므로 x2해준것 까지의 범위.
				arr[j] = 0;
		}
	}
}