import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int sum = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count();
		System.out.println(sum);
	}
	public static void count() { //시 , 분. 초 별로 for문을 돌려서 K가 나오는수가있으면 추가해줌.
		for(int h = 0; h<=N; h++) { //시에 대한 for문
			for(int m = 0; m<60; m++) { //분에 대한 for문
				for(int s = 0; s<60; s++) { //초에 대한 for문.
					if(h/10==K || h%10==K) {
						sum++;
					}else if(m/10==K || m%10==K) {
						sum++;
					}else if(s/10==K || s%10==K) {
						sum++;
					}
				}
			}
		}
	}
}