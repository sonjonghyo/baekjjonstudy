import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //독에 있는 구멍의 개수
		int M = Integer.parseInt(st.nextToken()); //햄스터의 부피
		int jar[] = new int[N]; //독의 구멍의 크기를 담아줄 배열입니다.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			jar[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0; //시작지점
		int end = 0; //끝지점.
		int maxVolume = 0; //최대 부피
		int sum = 0; //중간마다 최대부피를 구해줄 변수 sum
		while(end!=N) {
			if(sum <= M) { //아직 햄스터가 더 막을수있다면?
				sum += jar[end++]; //공간을 추가시켜줍니다.
			}else { //이제 더이상 못막는다면.
				sum -= jar[start++]; //앞의 공간을 빼줍니다.
			}
			if(sum <= M && maxVolume < sum) { //햄스터 크기안에 들며 새로운 sum이 최대부피보다 더 크다면
				maxVolume = sum; //갱신해줍니다.
			}
		}
		System.out.println(maxVolume);
	}
}