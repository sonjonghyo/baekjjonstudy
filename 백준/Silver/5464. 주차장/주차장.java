import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sum = 0;
		int Rs[] = new int[N+1];
		int Wk[] = new int[M+1];
		//주차장이 꽉차 못들어 가는 애들을 큐에 저장해준다.
		Queue<Integer> q = new LinkedList<>();
		//현재 주차장에 주차하고 있는 얘들 저장.
		int parking[] = new int[N+1];
		
		//주차장 마다 단위 요금.
		for(int i = 1; i < N+1; i++) {
			Rs[i] = Integer.parseInt(br.readLine());
		}
		//각 차량마다 무게.
		for(int i = 1; i < M+1; i++) {
			Wk[i] = Integer.parseInt(br.readLine());
		}
		loop : for(int i = 0; i < M * 2; i++) {
			int k = Integer.parseInt(br.readLine());
			//만약 주차를 해야하는 상황이라면?
			if(k > 0) {
				//전체 주차장을 돌며 빈공간 찾기
				for(int j = 1; j < N+1; j++) {
					//비어있다면?
					if(parking[j] == 0) {
						parking[j] = k;
						continue loop;
					}
				}
				//다 돌았는데 주차를 못했다.
				//큐에 추가시켜주기
				q.add(k);
			//차 빼기
			}else {
				for(int j = 1; j < N+1; j++) {
					if(parking[j] == k * -1) {
						//다시 빼주고
						parking[j] = 0;
						//값을 정산해준다. (주차장 단위면적당 가격 * 차량 무게값)
						sum += (Rs[j] * Wk[k * - 1]); 
						//그러고 큐에 대기하고 있는애 있다면 넣어주기.
						if(!q.isEmpty())
							parking[j] = q.poll();
						break;
					}
				}
			}
		}
		System.out.println(sum);
	}
}