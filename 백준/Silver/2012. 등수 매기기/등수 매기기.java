import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //학생의 수
		int grade[] = new int[N]; //학생의 수에 따른 값 구하기
		for(int i = 0; i < N; i++) {
			grade[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(grade); //등수를 오름차순으로 정렬해줍니다.
		long result = 0; //50만개에서 전부 1이라써있으면?.. int초과 
		for(int i = 1; i <= N; i++) { //1등부터 등수를 체크.
			result += Math.abs(grade[i - 1] - i); //현재 오름차순등수대로 등수 빼주기.
		}
		System.out.println(result);
	}
}