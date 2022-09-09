import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char s[]; //s가 들어갈 char형 배열.
	static int ACGT[] = new int[4]; //ACGT 알파벳 순서대로 배열작성. s를 만들어주기 위함.
	static char DNA[][]; //DNA가 들어갈 2차원 배열.
	static int HD = 0; //Hamming Distance의 길이
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		DNA = new char[N][M]; //DNA를 각 배열에 담아줄것임.
		for(int i = 0; i<N; i++) {
			String s = br.readLine(); //먼저 한줄의 DNA의 ACGT를 받아오고
			for(int j = 0; j<M; j++) {
				DNA[i][j] = s.charAt(j); //charAt함수를 이용해 하나씩 뽑아서 넣어주었다.
			}
		}
		makes(N,M); //가장 HD가 작은 DNA배열을 만들기 위해 함수를 만들어 사용.
		compare(N,M);
		System.out.println(sb);
	}
	public static void makes(int N, int M) {
		s = new char[M]; //먼저 s의 길이는 M만큼이어야하므로 s를 만들어주고
		for(int i = 0; i<M; i++) {
			Arrays.fill(ACGT, 0); //하나씩 ACGT를 채워나가면 ACGT의 내부를 0으로 초기화시켜준다.
			for(int j = 0; j<N; j++) {
				if(DNA[j][i] == 'A') { //ACGT의 횟수를 체크해준다.
					ACGT[0]++;
				}else if(DNA[j][i] == 'C') {
					ACGT[1]++;
				}else if(DNA[j][i] == 'G') {
					ACGT[2]++;
				}else {
					ACGT[3]++;
				}
			}
			int max = 0;
			for(int z = 0; z<4; z++) {
				if(max<ACGT[z]) { //횟수중 제일많은것을 max에 담아준다.
					max = ACGT[z];
				}
			}
			for(int z = 0; z<4; z++) {
				if(max==ACGT[z]) { //그중 ACGT를 알파벳순으로 하였기때문에 제일 먼저 나오는 순서대로 뽑아내주면된다.
					if(z==0) {
						s[i] = 'A';
					}else if(z==1) {
						s[i] = 'C';
					}else if(z==2) {
						s[i] = 'G';
					}else {
						s[i] = 'T';
					}
					sb.append(s[i]);
					break;
				}
			}
		}
		sb.append("\n");
	}
	public static void compare(int N, int M) {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(DNA[i][j]!=s[j]) { //DNA와 만들어진 s배열중 다른것만 HD를 추가해준다.
					HD++;
				}
			}
		}
		sb.append(HD);
	}
}