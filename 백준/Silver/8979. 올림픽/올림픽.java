import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int arr[][];
	static int rank = 1; //등수안의 배열 번호..
	static long grade[][]; //점수를 저장해줄 번호.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //국가의 수
		K = Integer.parseInt(st.nextToken()); //등수를 알고싶은 국가.
		arr = new int[N+1][3]; //등수와 금,은,동메달을 저장시켜줄 배열 열은 국가의수 +1, 행은 국가의 번호, 금,은,동의 개수이므로 4개.
		for(int i = 1; i<=N; i++) { //배열에 국가, 금,은,동메달 입력 (0번 배열은 비워둠. 보기쉽게 하기위해.)
			st = new StringTokenizer(br.readLine());
			int connum = Integer.parseInt(st.nextToken()); //국가의 번호.
			arr[connum][0] = Integer.parseInt(st.nextToken()); //금메달 수
			arr[connum][1] = Integer.parseInt(st.nextToken()); //은메달 수
			arr[connum][2] = Integer.parseInt(st.nextToken()); //동메달 수
		}
		check();
		System.out.println(rank);
		
	}
	public static void check() { 
		for(int i = 1; i<=N; i++) {
			if(arr[i][0] > arr[K][0]) { //나보다 금메달 수가 많은거면 나보다 랭크가 높으므로 등수를 하나 올려줌.
				rank++;
			}else if(arr[i][0] == arr[K][0] && arr[i][1] > arr[K][1]) { //금메달수는 같지만 은메달수가 많으면 하나 올려줌.
				rank++;
			}else if(arr[i][0] == arr[K][0] && arr[i][1] == arr[K][1] && arr[i][2] > arr[K][2]) { //금,은의 수도 같고 동메달도 많으면 수 하나 올려줌.
				rank++;
			}
		}
	}
}