import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int my = 0; // 내위치를 저장할 변수
		int tmp = 0; //위치 저장하는 변수
		int sum = 0; //마지막 합.
		int map[] = new int[N];
		int round = (row + col) * 2; //둘레의 길이.
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int compass = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			switch (compass) { //전부 시계방향일때의 위치 ((북서쪽)왼쪽위가 0,0 시작점)
			case 1:
				tmp = point;
				break;
			case 2:
				tmp = row+col+row-point;
				break;
			case 3:
				tmp = round - point;
				break;
			case 4:
				tmp = row + point;
				break;
			}
			if(i<N) { //초과한것은 내 위치를 표현. 아닌것은 배열에 담기.
				map[i] =tmp;
			} else {
				my = tmp;
			}
		}
		for(int i = 0; i< N; i++) {
			int cw = Math.abs(my-map[i]);
			int rcw = round-cw;
			sum += Math.min(cw, rcw);
		}
		System.out.println(sum);

	}
}