import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String email = br.readLine();
		int len = email.length();
		char e[] = new char[len]; //email을 각 하나의 알파벳으로 배열에 저장.
		int cnt = 0; //나중에 옮길때 배열의 인덱스
		List<Integer> li = new ArrayList<>(); //email의 길이의 약수를 저장해줄 리스트이다.
		for(int i = 1; i<=len; i++) {
			if(len%i==0) { //만약 길이가 i로 나누어떨어지면
				li.add(i); //리스트에 추가를 해주어 약수를 구해준다.
			}
			e[i-1] = email.charAt(i-1); //e의char배열에 email의 알파벳 하나씩 저장해준다.
		}
		int N = 0;
		int M = 0;
		if(li.size()%2==0) { //만약 사이즈가 짝수개라면 사이즈의 중간과 -1한것이므로
			N = li.get(li.size()/2); //사이즈중간
			M = li.get((li.size()/2)-1); //그 전것.
		}else { //만약 사이즈가 홀수라면 중간에있는 값을 N과 M에 쓸수있으므로
			N = li.get(li.size()/2); //사이즈중간값.
			M = N; //그대로 M에 복사.
		}
		char arr[][] = new char[N][M]; //위에서 구한 값을 토대로 char형 2차원 배열을 생성해주었다.
		for(int i = 0; i<N; i++) {
			for(int j=0; j<M; j++) { 
				arr[i][j] = e[cnt]; //먼저 arr배열에 이메일을 하나씩 -> 방향으로 넣어준다.
				cnt++;
			}
		}
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				System.out.print(arr[j][i]); //이 부분은 출력할때 열부분이 먼저 동작하게 만들어주었다.
			}
		}

	}

}
