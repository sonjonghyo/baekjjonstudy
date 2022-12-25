import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken()); //배열 A의 크기 N
		int M = Integer.parseInt(st.nextToken()); //배열 B의 크기 M
		int A[] = new int[N]; //배열 A는 N의 크기로 생성
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int B[] = new int[M]; //배열 B는 M의 크기로 생성
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		int a  = 0; //A배열의 시작위치지정
		int b = 0; //B배열의 시작위치지정
		int r = 0; //result배열의 위치를 지정.
		int result[] = new int[N+M];
		while(a < N && b < M) { //처음엔 둘다 비교해주는 식으로 해줍니다.
			if(A[a] > B[b]) { //만약 A의 배열값이 B의 배열값 보다크다면?
				result[r++] = B[b++]; //결과값에 값이 더 작은 B배열의 b위치에 있는 것을 넣어줍니다.
				//후위 증감연산자를 사용한 이유는 다음에 볼때 한칸 뒤의 것을 봐야하기 때문입니다.
			}else { //반대라면?
				result[r++] = A[a++];
			}
		}
		//여기에서 남은 애들은 현재 result에 누적되어있는 수들 보다 전부 큰 수 이기 때문에 뒤에 차례대로 넣어주면 됩니다.
		while(a < N) { //위에서 둘중 하나만 false만 되어도 while문이 끝나므로 아래에서 남은 것을 처리해주어야합니다.
			result[r++] = A[a++]; //A배열에 해당하는 남은 것을 전부 넣어줍니다.
		}
		while(b < M) {
			result[r++] = B[b++];
		}
		for(int i = 0; i < N+M; i++) {
			sb.append(result[i]); //StringBuilder에 결과 배열을 누적시키고.
			if(i != N+M-1) //마지막이 부분을 제외하고는
				sb.append(" "); //띄어쓰기를 첨부해줍니다.
		}
		System.out.println(sb); //마지막으로 출력해줍니다.
	}
}