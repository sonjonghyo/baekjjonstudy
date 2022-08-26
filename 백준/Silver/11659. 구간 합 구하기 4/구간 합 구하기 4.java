import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int num[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<N; i++) {
			num[i] += num[i-1]; //누적합을 구해 그 차를 이용해 구간합을 구할 것임.
		}
		for(int a = 0; a<M; a++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()); //시작 위치
			int j = Integer.parseInt(st.nextToken()); //끝나는 위치
			if(i-1==0) { //만약 i-1이 0이라면 즉 시작위치가 맨처음이라면
				sb.append(num[j-1]); //배열에 저장했기때문에 0번인덱스 부터 시작하므로 누적합이 되어있는 j-1번째 num을 저장해준다.
			}else {
				sb.append(num[j-1]-num[i-2]); //아닐시에는 i는 시작위치 이므로 i-2부터 j는 끝이므로 j-1까지해주어 구간합을 찾아준다.
			}
			if(a!=M-1) //마지막부분을 제외하고는 개행문자를 추가해준다.
				sb.append("\n");
		}
		System.out.println(sb);
	}
}