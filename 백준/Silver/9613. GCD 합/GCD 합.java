import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[]; // 각 수를 저장해줄 배열
	static long sum; // 최대공약수들의 합을 저장해줄 수.(GCD의 합이 int의 범위를 넘어갈수있으므로 long으로 줌)
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			sum = 0; //tc가 하나 끝날때마다 GCD의 합을 0으로 초기화 해준다.
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr = new int[n]; //n개만큼 배열의 크기 설정을 해준다.
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); //배열에 각 수를 저장.
			}
			GCD(); //유클리드 호제법을 사용한 최대공약수를 구해주는 함수.
		}
		System.out.println(sb);
	}

	public static void GCD() {
		for (int i = 0; i < arr.length - 1; i++) { //나와 내 다음수를 비교해주는것이므로 처음것은 최대길이-1까지의 범위
			for (int j = i + 1; j < arr.length; j++) { 
				int b = 0; //큰 수를 저장해줄 변수
				int s = 0; //작은 수를 저장해줄 변수.
				if (arr[i] > arr[j]) { //큰 수 작은 수 측정.
					b = arr[i];
					s = arr[j];
				} else {
					b = arr[j];
					s = arr[i];
				}
				int tmp = 0; //큰 수와 작은 수의 나머지가 0이아닐때 나머지를 저장해줄 변수
				while (true) { //나머지가 0이될때까지 while문을 돌린다.
					if (b % s != 0) { //큰 수 % 작은 수가 0이 아니라면 아직 최대공약수가 아니므로
						tmp = b % s; //먼저 큰 수 에서 작은 수를 나눈 나머지를 tmp에 저장해주고
						b = s; //작은 수를 큰 수로 바꿔준 후에
						s = tmp; //나머지를 작은 수로 바꾸어 주는것을 반복하는 것이 유클리드 호제법이다.
					} else { //만약 나머지가 0이되었다면 그 작은 수가 최대 공약수 라는 뜻이므로
						sum += s; //작은수를 sum에 누적시켜준 후에
						break; //while문을 끝내주고 다음 GCD를 구한다.
					}
				}
			}
		}
		sb.append(sum).append("\n"); //GCD가 한번끝날때마다 stringBuilder에 저장해준다.
	}
}