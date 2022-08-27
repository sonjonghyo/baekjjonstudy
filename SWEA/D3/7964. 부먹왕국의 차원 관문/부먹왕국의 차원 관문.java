import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int D;
	static int building[];
	static int cnt;
	static int result; //차원관문을 몇개 세웠는지 확인해주는 변수. 
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //부먹왕국의 도시 수
			D = Integer.parseInt(st.nextToken()); //이동 제한 거리.
			building = new int[N+2]; //크기를 N+2로 해준 이유는 0번째와 N+1번째는 무조건 차원관문이 설치되므로 그것까지 고려하기 위해서이다.
			building[0] = 1; //0번째 위치 차원관문 존재
			building[N+1] = 1; //N+1번째 위치 차원관문 존재
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<N+1; i++) {
				building[i] = Integer.parseInt(st.nextToken()); //1번째부터 N번째까지 차원관문 입력하기.
			}
			build();
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		
	}
	static void build() {
		result = 0; //차원관문 세운개수 0개로 초기화.
		for(int i = 1; i<N+1; ) { //1번부터 N번까지 확인.
			cnt = 0; 
			if(building[i]==1) { //만약 차원관문이 있다면?
				i++; //다음부분 확인에 들어갑니다~
				continue; //for문으로 돌아가기.
			}else { //만약 차원관문이 없다면?
				for(int j = 0; j<=D; j++) { //이동할수 있는 제한거리수가 D이므로 D까지만 이동하게 한다.
					if(building[i+j] == 0) { //만약 지어진 차원관문이 없다면.
						cnt++; 
					}else { //차원관문이 존재한다면.
						i += j; //j만큼 이동한것이므로 i에 j를 더해준다.
						break; //그러고 이안의 for문을 끝내주고 i의 for문으로 돌아간다.
					}
					if(cnt==D) { //만약 cnt의 개수가 이동제한 거리와 같아졌다면 차원관문을 설치해야하므로
						building[i+D-1] = 1; //자기포함 개수이므로 D-1을 해주어야 차원관문에서 D만큼 떨어진 곳에 세워진다.
						result++; //차원관문 세운 개수 1개추가.
						i += D; //최대거리만큼왔으니 최대거리만큼 이동해준다.
						break;
					}	
				}
				
			}
		}
		sb.append(result);
	}
}