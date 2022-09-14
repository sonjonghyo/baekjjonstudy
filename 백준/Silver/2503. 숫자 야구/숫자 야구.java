import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int check = 0;
	static int baseball[][];
	static int max = 0;
	static int min = 1000;
	static int N;
	static int result = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //질문의 횟수
		baseball = new int[N][3]; //처음열에는 생각한 숫자를 두번째열에는 스트라이크의 갯수를 세번째열에는 볼의개수를 쓸것.
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			baseball[i][0] = Integer.parseInt(st.nextToken());
			baseball[i][1] = Integer.parseInt(st.nextToken());
			baseball[i][2] = Integer.parseInt(st.nextToken());
		}
		hit();
		System.out.println(result);
		
	}
	public static void hit() {  //스트라이크 볼 판별해주는 함수.
		for(int i = 123; i<=999; i++) { //최소수부터 최대수까지 for문을 돌린다.
			String sm = String.valueOf(i);  //먼저 문자열로 바꾸고 하나하나씩 비교.
			if(sm.contains("0"))
				continue;	
			int a = i/100; //백의자리
			int b = (i-(a*100))/10; //십의자리
			int c = i%10; //일의자리
			if(a==b || a==c || b==c) //숫자가 같으면 안되므로 만약 같은수가 있을시에 continue로 다음수로 이동.
				continue;
			int cnt = 0;
			for(int j = 0; j<N; j++) {
				int x = baseball[j][0];
				int strike = 0; //스트라이크 횟수
				int ball = 0; //볼 횟수
				String my = String.valueOf(x);
				for(int z = 0; z<3; z++) {
					for(int d = 0; d<3; d++) { //이부분 수정해야함.
						if(my.charAt(z)==sm.charAt(d)) { //볼의 개수 확인.
							ball++; //스트라이크,볼의 개수 둘다 구해짐.
							continue;
						}
					}
					if(sm.charAt(z)==my.charAt(z)) { //스트라이크라면
						strike++; //스트라이크 횟수 추가
						ball--; //스트라이크가 한개 늘었으니 볼의 개수 한개 감소.
						continue; //그러고 다시 다음번.
					}
				}
				if(baseball[j][1]==strike && baseball[j][2]==ball) { //스트라이크와 볼의 갯수가 내가 정해준것과 같다면
					cnt++; //cnt를 추가시켜준다.
				}
			}
			if(cnt==N) { //만약 cnt가 N의 개수와 같으면
				result++; //전부다 맞은것이므로 결과값을 1추가시켜준다.
			}
		}
	}
}