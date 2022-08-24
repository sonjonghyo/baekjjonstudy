import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //참가자의 수
		int B = Integer.parseInt(st.nextToken()); //예산
		int H = Integer.parseInt(st.nextToken()); //호텔의 수
		int W = Integer.parseInt(st.nextToken()); //고를수 있는 주의 개수
		int arr[] = new int[W];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<H; i++) {
			int P = Integer.parseInt(br.readLine()); //1인당 숙박비용
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W; j++) {
				arr[j] = Integer.parseInt(st.nextToken()); //각 주에 투숙 가능한 인원입력
			}
			for(int j = 0; j<W; j++) {  //만약 투숙가능한 인원이 참가자 수보다 적다면
				if(arr[j]<N) {
					continue;
				} else {
					int price = P*N; //if문에 안걸렸으므로 j번째주에는 참가가 가능함. 그때 총 써야하는 금액은 참가자수*인당 숙박비용
					if(price < B) { //만약 총 써야하는 금액이 예산보다 적다면 입장할수 있으므로
						if(min > price) //이때 현재 써야하는 금액이 다른 곳에서 사용할 금액보다 적다면
							min = price; //최소금액을 현재 금액으로 바꿔준다.
					}
				}
			}
		}
		if(min == Integer.MAX_VALUE) { //만약 한번도 거치지않아서 초기값 그대로라면
			System.out.println("stay home"); //결국 시험을 못치뤘다. 집에머물러야한다.
		}else {
			System.out.println(min); //아닐경우에는 최소금액 min만큼 내고 시험을 볼수있다.
		}	
	}
}