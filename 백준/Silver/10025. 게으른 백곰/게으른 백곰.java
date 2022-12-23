import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //얼음의 개수
		int K = Integer.parseInt(st.nextToken())*2; //얼만큼 떨어진것을 집을수있는지.
		//좌우 이므로 K에 *2를 해줍니다.
		int ice[] = new int[1000001]; //100만개의 양동이
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gi = Integer.parseInt(st.nextToken()); //얼음의 양
			int xi = Integer.parseInt(st.nextToken()); //양동이의 좌표
			ice[xi] = gi;  //얼음이 몇개 들었는지 넣어주기.
		}
		int maxSum = 0;
		if(K>=999999) { //모든 범위를 다 볼수 있다면?
			for(int i = 0; i < ice.length; i++) {
				maxSum += ice[i]; //얼음 더해주기.
			}
		}else {
			int count = 0;
			int sum = 0;
			int start = 0;
			for(int i = 0; i < ice.length; i++) {
				if(count == K+1) {
					sum -= ice[start++]; //맨 앞에서 부터 빼주어야 하므로 start를 해주고
					//후위 증감연산자를 사용하여 다음번에는 한칸 더 뒤의 갚을 빼줍니다.
					sum += ice[i];
				}else { //count가 K와 다르다면?
					sum += ice[i]; //우선 sum을 누적시켜주고
					count++; //count를 증가시켜줍니다.
				}
				if(maxSum < sum) //만약 중간에서 담을수 있는 얼음의 양이 더 크다면?
					maxSum = sum; //최대값을 바꾸어줍니다.
			}
		}
		System.out.println(maxSum);
	}
}