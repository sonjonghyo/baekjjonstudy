import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); //1시간일하면 쌓이는 피로도
		int B = Integer.parseInt(st.nextToken()); //1시간일하면 처리하는 일
		int C = Integer.parseInt(st.nextToken()); //1시간 쉬면 없어지는 피로도
		int M = Integer.parseInt(st.nextToken()); //최대 피로도.
		int piro = 0; //피로도
		int work = 0; //일한양
		int time = 24; //하루는 24시간
		for(int i = 0; i<time; i++) {
			if(A>M)  //일 때려쳐
				break;
			if(piro+A<=M) { //만약 현재피로도에서 1시간일하고나서의 피로도가 M보다 작거나 같으면.
				piro += A; //1시간일했으니 피로도 A만큼 증가.
				work += B; //일한양 B만큼 추가.
			}else {
				piro -= C; //쉬었으니 피로도감소.
				if(piro<0) //피로도는 최소0이므로 만약 0보다 작아진다면
					piro = 0; //0으로 만들어주자.
			}
		}
		System.out.println(work);
	}
}