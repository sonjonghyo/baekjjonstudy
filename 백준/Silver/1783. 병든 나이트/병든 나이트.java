import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//M이 6보다 작을시에는 무조건 4이하로만 나옴.
	//4일시에는 8이랑 같거나 크면 4번가능
	//3일시에는 6 3번
	//2일시에는 4 2번
	//5부터는 전부다 돌아야하므로 N이 최소 3, M이 7보다 커야함
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long cnt = 1;
		if(M==1) {
			cnt = 1;
		}else if(M==2) {
			if(N>=3) { //위로두칸 오른쪽으로 한칸 갈수있는 경우임.
				cnt = 2;
			}
		}else if(M==3) {
			if(N>=3) {
				cnt = 3;
			}else if(N==2) {
				cnt = 2;
			}
		}else if(M==4) {
			if(N>=3) {
				cnt = 4;
			}else if(N==2){
				cnt = 2;
			}
		}else if(M==5 || M==6) {
			if(N>=3) {
				cnt = 4;
			}else if(N==2){
				cnt = 3;
			}
		}else { //M이 7보다 클때.
			if(N==1) {
				cnt = 1;
			}else if(N==2) {
				cnt = 4;
			}else if(N>=3) {
				M -= 7;
				cnt = 5+M;
			}
		}
		System.out.println(cnt);
	}
}