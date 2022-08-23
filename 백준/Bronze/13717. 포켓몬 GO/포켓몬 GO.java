import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //포켓몬이 몇종류 있는지 입력.
		String name[] = new String[N]; //그 포켓몬들의 이름을 저장하기 위해 String형태의 1차원배열 N크기만큼 생성.
		int evolution[] = new int[N]; 
		int sum = 0;
		for(int tc = 0; tc<N; tc++) {
			name[tc] = br.readLine(); //이름을 넣어준다.
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken()); //진화하는데 필요한 사탕의 개수
			int M = Integer.parseInt(st.nextToken()); //내가 가지고있는 사탕의 개수
			while(true) {
				if(M>=K) {
					M = M-K+2; //진화를 한번하면 K만큼빠지고 2개를 돌려받음.
					evolution[tc]++; //진화했으므로 1을 추가해준다.
					sum++; //총 몇번 진화했는지 누적으로 추가해준다.
				}else {
					break;
				}
			}
		}
		int max = Integer.MIN_VALUE; //내부에서 가장 큰 수를 찾기 위해 max변수 선언.
		int maxidx = 0; //가장 큰 수의 인덱스를 찾기위해 maxidx사용
		for(int i = 0; i<N; i++) {
			if(max<evolution[i]) { //만약 max보다 i번째의 evolution배열이 더 크다면
				max = evolution[i]; //evolution[i]를 max에 저장
				maxidx = i; //현재 위치인 i를 maxidx에 저장해준다.
			}
		}
		System.out.println(sum); //누적합 출력
		System.out.println(name[maxidx]); //어떤 포켓몬이 가장 많이,빨리진화했는지 출력
	}
}