import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //행렬의 세로길이
        int M = Integer.parseInt(st.nextToken()); //행렬의 가로길이
        int Arrange[][] = new int[N][M]; //행렬 생성
        int cumsum[][] = new int[N][M]; //누적합 행렬 생성
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                Arrange[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) { //누적합 넣어주기.
            for(int j = 0; j < M; j++) {
                if(j == 0) {
                    cumsum[i][j] = Arrange[i][j];
                }else {
                    cumsum[i][j] += cumsum[i][j-1] + Arrange[i][j];
                }
            }
        }
        int K = Integer.parseInt(br.readLine()); //순서대로 배열의 합 출력하기
        int sum = 0; //누적합을 저장해줄 변수입니다.
        for(int tc = 1; tc<=K; tc++) {  //K번 만큼 반복하기.
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            //-1을 해준 이유는 배열의 시작은 0번부터이기 때문입니다.
            sum = 0;
            if(j == 0) { //만약 시작지점이 0이라면?
                for(int a = i; a <= x; a++) {
                    sum += cumsum[a][y]; //끝의 누적의 합을 구해줍니다.
                }
            }else { //시작지점이 0이아니라면?
                for(int a = i; a <= x; a++) {
                	if(y==j) { //만약 두개가 서로 같다면?
                		sum += Arrange[a][y];
                	}else {
                		sum += (cumsum[a][y]-cumsum[a][j-1]); //이전것을 뺀 누적합을 sum에                		
                	}
                }
            }
            sb.append(sum);
            if(tc != K) //끝이 아니라면 개행문자 추가.
                sb.append("\n");
        }
        System.out.println(sb); 
    }
}