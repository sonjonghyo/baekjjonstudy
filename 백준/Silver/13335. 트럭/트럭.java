import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //트럭의 개수
		int w = Integer.parseInt(st.nextToken()); //다리의 길이
		int L = Integer.parseInt(st.nextToken()); //다리의 최대 하중.
		int weight[] = new int[n];
		int time[] = new int[n]; //각 트럭이 들어온 시간을 넣어줄거야.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(st.nextToken()); //배열에 트럭들의 무게 실어주기.
		}
		int answer = 0; //총 걸린 시간을 담당할 변수입니다.
		int cnt = 0; //현재 나올 트럭의 배열 위치를 나타낼 변수
		int pass = 0; //빼줄 차량의 위치
		int curweight = 0; //현재 다리위에있는 트럭의 총 무게
		while(pass < n) { 
			if(time[pass] + w == answer) { //다리를 다 지나간 경우를 의미함.
				curweight -= weight[pass++]; //현재 총 무게에서 지나간거 빼줘.
			}
			if(cnt < n && curweight + weight[cnt] <= L) { //현재 다리위에있는 트럭의 무게와 다음에 실릴 무게가 최대 하중보다 크다면?
				time[cnt] = answer; //현재 들어온 시간을 넣어줘.(answer를 마지막에 ++할거라 사실상 이전 시간이 들어감)
				curweight += weight[cnt++]; //기다리는 맨앞 트럭을 실어줘.
			}
			answer++;
		}
		System.out.println(answer);
	}
}