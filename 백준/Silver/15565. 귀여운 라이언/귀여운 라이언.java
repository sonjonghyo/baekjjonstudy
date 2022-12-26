import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //어피치 인형의 개수
		int K = Integer.parseInt(st.nextToken()); //라이언 인형이 K개 이상 있는 가장 작은 연속된 인형들의 집합.
		int lion[] = new int[N];
		int size = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			lion[i] = Integer.parseInt(st.nextToken()); //1은 라이언 2는 어피치인형.
			if(lion[i]==1) //라이언이면?
				size++; //라이언의 개수 증가.
		}
		if(size < K) { //만약 라이언의 수가 라이언인형 이상 있어야 하는 개수보다 적다면
			System.out.println(-1); //-1을 출력해줍니다.
		}else if(K == 1) {
			System.out.println(1); //K가 1이면 무조건 1개이므로 1을 출력.
		}else {
			int lionsize[] = new int[size]; //라이언의 크기 생각하기.
			int liondoll = 1; //다음 라이언 인형까지의 거리.
			int cnt = 0;
			boolean flag = false;
			for(int i = 0; i < N; i++) {
				if(lion[i] == 1) { //만약 라이언 인형을 만났다면?
					flag = true; //true로 변경.
					lionsize[cnt++] = liondoll; //lionsize에 라이언 인형 길이만큼 넣어줍니다.
					liondoll = 1; //다시 길이 초기화.
				}else { //어피치 인형이라면?
					if(flag) //인형이 아직 안나왔다면 인형추가X
						liondoll++; //길이 추가.
				}
			}
			int start = 1; //투 포인터 시작위치
			int end = 0; //끝위치.
			cnt = 0;
			int sum = 0; //집합의 길이.
			int minimum = Integer.MAX_VALUE; //가장 작은 연속된 집합 크기 구하기.
			for(int i = 0; i < size; i++) { //사이즈 만큼 구하기.
				if(cnt == K) { //만약 cnt가 K개 이상있는 가장 작은 연속된 인형이라면
					if(minimum > sum) //가장 먼저 가장 작은 배열인지 확인해 준후
						minimum = sum;
					sum -= lionsize[start++];  //시작부분을 빼고
					sum +=lionsize[end++]; //끝 부분을 더해줍니다.
				}else { //K개 이하라면
					sum +=lionsize[end++]; //아직은 계속 누적시켜주고
					cnt++; //라이언 뽑은 갯수 증가.
				}
			}
			if(minimum > sum) //마지막 부분을 처리하지 못하므로.
				minimum = sum;
			System.out.println(minimum);
			
		}
	}
}