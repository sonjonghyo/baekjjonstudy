import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //총 학생의 수
		int K = Integer.parseInt(st.nextToken()); //방안에 들어갈수 있는 최대 학생 수
		int arr[] = new int[12]; //6학년까지 남녀 학생수 0,1은 1학년 2,3은 2학년 4,5는 3학년 이런식
		int room = 0; // 방의 개수
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			switch(Y) { //switch문으로 학년별로 구분해주고 그 안에 0은 여학생 1은 남학생으로 구분해 배열에 넣어준다.
			case 1:
				if(S==0) {
					arr[0]++;
				}else {
					arr[1]++;
				}
				break;
			case 2:
				if(S==0) {
					arr[2]++;
				}else {
					arr[3]++;
				}
				break;
			case 3:
				if(S==0) {
					arr[4]++;
				}else {
					arr[5]++;
				}
				break;
			case 4:
				if(S==0) {
					arr[6]++;
				}else {
					arr[7]++;
				}
				break;
			case 5:
				if(S==0) {
					arr[8]++;
				}else {
					arr[9]++;
				}
				break;
			case 6:
				if(S==0) {
					arr[10]++;
				}else {
					arr[11]++;
				}
				break;
			}
		}
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == 0) { //만약 방에 아무도 없는 경우에는
				continue; //방을 추가안해줘도 되므로 continue를 사용해준다.
			}else if(arr[i] <= K) { //만약 0보단크지만 K보다 같거나 작을시에
				room++; //방 1개를 줘야하므로 room에 1을 더해준다.
			}else { //K보다 클시에는 K개이상방이 들어가므로
				room++; //처음에 방을 1개 주고
				while(arr[i]>K) { //arr[i]가 K보다 작을시에는 동작 안하게하고  
					arr[i] -= K; //한번 돌때마다 arr[i]를 K씩감소시킨다 (학생을 K명씩빼준다.)
					room++; //2명이 빠졌으니 그 빠진학생수의 방1개를 지급해준다.
				}
			}
		}
		System.out.println(room);
	}
}