import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine()); //X번째 분수를 구하기 위해 사용
		int cross = 1; //대각선의 개수
		int cross_sum = 0; //누적합.
		while(true) {
			if(X <= cross_sum + cross) { //현재 대각선의 누적합 개수와 새로운 대각선의 개수보다 X가 작다면?
				//작다면 이제 cross 대각선에 값이 있는 것이므로 확인해 줍니다.
				if(cross % 2 == 1) { //대각선의 개수가 홀수면 아래에서 위로(분자는 작아지고 분모는 커지는 형태입니다.)
					System.out.println((cross - (X - cross_sum - 1)) + "/" + (X - cross_sum));
					break;
				}else { //대각선의 개수가 짝수라면 위에서 아래로(분자는 커지고 분모가 작아지는 형태입니다.)
					System.out.println((X - cross_sum) + "/" + (cross - (X - cross_sum - 1)));
					break;
				}
			}else {
				cross_sum += cross;
				cross++;
			}
		}
	}
}