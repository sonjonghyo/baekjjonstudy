import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //수열의 개수 입력.,
		int M = Integer.parseInt(st.nextToken()); //합이 M이 되는 것을 찾기위한 수
		int array[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int start = 0;
		int end = 0;
		int count = 0; //몇개의 경우의 수인지 체크.
		while(end!=N) { //while문은 end가 배열의 밖으로 나가게 된다면 끝내줍니다.
			if(sum < M) { //sum이 M보다 작은경우엔?
				end++; //끝을 늘려주고
				sum += array[end-1]; //합을 가장 끝부분을 추가시켜줍니다.
			}else if(sum > M) { //만약 sum이 M보다 큰 경우엔?
				start++; //시작위치를 한칸 이동시키고
				sum -= array[start-1]; //합을 가장 첫부분을 빼줍니다.
			}
			if(sum == M) { //만약 그렇게하고나서 sum과 M이 같다면?
				count++; //가능한 횟수를 1번 증가시켜주고
				start++; //시작위치를 한칸 땡긴 후
				sum -= array[start-1]; //합의 가장 첫 부분을 빼줍니다.
			}
		}
		while(start!=N) { //마지막 시작위치를 끝까지 보내주는 작업.
			start++; 
			sum -= array[start-1];
			if(sum == M) {
				count++;
			}
		}
		System.out.println(count); //count를 출력해줍니다.
	}
}