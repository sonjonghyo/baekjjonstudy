import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //총 건물의 개수
		int D = Integer.parseInt(st.nextToken()); //수행한 날의 수
		int building[] = new int[300001]; //총 높이가 최대 30만이므로 다 저장할수있는 것 생성.
		int max = 0; //건물중에서 가장 높은 높이.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int h = Integer.parseInt(st.nextToken());
			if(h > max) {
				max = h;				
			}
			building[h]++;
		}
		long razer = 0; //레이저를 발사한 횟수.
		for(int i = 0; i<D; i++) {
			if(max == 0)
				break;
			razer += building[max];
			building[max-1] += building[max];
			building[max] = 0;
			max -= 1;
		}
		System.out.println(razer);
	}
}