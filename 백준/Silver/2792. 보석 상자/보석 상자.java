import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		//보석을 나눠 주어야 할 학생의 수
		int N = Integer.parseInt(st.nextToken());
		//보석 색상의 수.
		int M = Integer.parseInt(st.nextToken());
		int jewel[] = new int[M];
		
		//이분 탐색을 위한 왼쪽, 오른쪽, 중간.
		int left = 1;
		int right = 0;
		int mid = 0;
		int sum = 0;
		int answer = 0;
		
		//각 보석 색상에 맞게 보석을 넣어주자.
		for(int i = 0; i  < M; i++) {
			jewel[i] = Integer.parseInt(br.readLine());
			//오른쪽 값 갱신.(가장많은 보석을 오른쪽)
			if(jewel[i] > right)
				right = jewel[i];
		}
		
		while(left <= right) {
			//질투심이 중간값까지 되도록 갱신
			mid = (left + right) / 2;
			sum = 0;
			for(int i = 0; i < M; i++) {
				//먼저 나눠주는 양 정리해서 나눠주자.
				sum += jewel[i] / mid;
				//나누어 떨어지지 않으면 1명한테 더 줄수 있으니 1추가.
				if(jewel[i] % mid != 0)
					sum++;
			}
			
			//만약 나눠 줄수 없는 경우라면?
			if(sum > N) {
				left = mid + 1;				
			//나눠 줄 수 있는 경우라면?
			}else {
				right = mid - 1;
				//이때의 mid값을 결과값에 저장해 놓아야함.
				answer = mid;
			}
		}
		System.out.println(answer);
	}
}