import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 스크린의 칸
		int M = sc.nextInt(); // 스크린 아래쪽에 M칸을 차지하는 바구니
		// M<N
		int J = sc.nextInt(); // 떨어지는 사과의 개수
		int drop[] = new int[J];
		for (int i = 0; i < J; i++) {
			drop[i] = sc.nextInt();
		}
		int cur = M; // 바구니의 처음위치는 왼쪽 M칸이므로 cur의 위치를 M으로 설정.
		int cnt = 0; // 이동거리
		for (int i = 0; i < J; i++) {
			while(true) {
				if(drop[i] >= (cur-(M-1)) && drop[i] <= cur) { //바구니 현재위치와 바구니 크기 내에 있을때.
					break;
				}else {
					if(drop[i] > cur) { //떨어지는 위치가 현재보다 클시
						cnt++; //이동횟수 추가
						cur++; //거리 추가
					}else { //반대일시
						cnt++; //이동횟수 추가
						cur--; //거리 감소
					}
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}