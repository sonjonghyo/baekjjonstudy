import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[A];
		int result[] = new int[A];
		int cnt = 0;
		int c1 = 0;
		int c2 = 0;
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = arr.length-1; i>=0; i--) { //문제를 보면 정렬을 끝에서 부터 시작함. 따라서 배열의 길이 -1부터 시작해주고
			int swapcnt = i;
			int max = arr[i];
			for(int j = i-1; j>=0; j--) { //아래에는 그것보다 하나 작은 수부터 시작해준다.
				if(max < arr[j]) {
					max = arr[j];
					swapcnt = j;
				}
			}
			if(swapcnt != i) {
				int tmp = arr[i];
				arr[i] = arr[swapcnt];
				arr[swapcnt] = tmp;
				cnt++;
				if(cnt == K) {
					for(int a=0; a<A; a++) {
						result[a] = arr[a];
					}
				}
			}
		}
		if(cnt<K) { //만약 비교횟수 K 보다 더 작게 돌았다면
			System.out.println(-1); //-1을 출력해주며
		}else {
			for(int i = 0; i<A; i++) {
				System.out.print(result[i] + " ");
			}
		}
	}
}