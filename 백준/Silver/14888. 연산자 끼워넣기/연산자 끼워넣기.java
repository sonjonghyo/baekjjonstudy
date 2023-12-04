import java.io.*;
import java.util.*;

public class Main {
	//수의 개수
	static int N;
	//어떤 수가 들어있는지 넣어줄 배열입니다.
	static int num[];
	//연산자가 몇개있는지 넣어줄 배열입니다.(0 -> +, 1 -> -, 2 -> *, 3 -> /)
	static int op[] = new int[4];
	//최솟값과 최댓값을 저장해줄 변수 입니다.
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		//계산해줄 함수입니다.
		calcul(num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	private static void calcul(int sum, int idx) {
		//기저 조건
		//idx 랑 N이랑 같아진다는 것은 연산이 끝난 것.
		if(idx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			//연산자가 있어야 계산이 가능하니 0이상일때만 가능.
			if(op[i] > 0) {
				op[i]--;
				switch(i) {
				case 0: //덧셈.
					calcul(sum + num[idx], idx + 1);
					break;
				case 1: //뺄셈
					calcul(sum - num[idx], idx + 1);
					break;
				case 2: //곱셈
					calcul(sum * num[idx], idx + 1);
					break;
				case 3: //나눗셈
					calcul(sum / num[idx], idx + 1);
					break;
				}
				//위의 함수가 끝나면 다시 사용할 수 있으니 추가시켜준다.
				op[i]++;
			}
		}
		
	}
}