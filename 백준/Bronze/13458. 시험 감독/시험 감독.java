import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int N = Integer.parseInt(br.readLine()); //시험장의 개수
		int room[] = new int[N]; //개수만큼 배열만들어서
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			room[i] = Integer.parseInt(st.nextToken()); //각 시험장마다의 응시자수 Ai
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); //총감독관이 한 시험장에서 감시할 수 있는 응시자 수
		int C = Integer.parseInt(st.nextToken()); //부감독관이 한 시험장에서 감시할 수 있는 응시자 수
		//총 감독관은 오직 1명. 부 감독관은 여러명 있어도됀다.
		//B는 1번만 쓸수있고 C는 여러번 사용가능함. 먼저B에대해서 까주고 C에대해서 계산해주면 될거같다고 생각.
		long num = N;
		for(int i = 0; i<N; i++) {
			room[i] -= B; //먼저 총 감독관 수 1명에 대해 B명을 모든 방에 빼주기.
		}
		for(int i = 0; i<N; i++) {
			if(room[i]>0) {
				if((room[i]%C)!=0) { //방안의 사람수와 부감독관이 감시할수 있는 사람을 나눴을때의 나머지가 0이아니라면
					num += room[i]/C + 1; //나눈것보다 1명 더 필요하다는것이고
				}else { //나눴을때 0이라면
					num += room[i]/C; //나눈만큼의 사람이 필요하다.
				}				
			}
		}
		System.out.println(num);
	}
}