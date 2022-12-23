import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //수열의 길이
		int K = Integer.parseInt(st.nextToken()); //최대로 쌓일수 있는 개수.
		int number[] = new int[100001]; //현재 나온 수가 몇개 나왔는지 담아줄 배열입니다.
		int array[] = new int[N]; //수열
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int size = 0;
		int maxSize = 0;
		while(end!=N) {
			if(number[array[end]]+1 <= K) { //같은 정수가 적다면?
				size++; //수열의 크기 증가.
				number[array[end]]++; //배열에 해당하는 부분의 수를 추가해줍니다.
				end++; //끝부분을 추가해줍니다.
			}else { //같은 정수가 더 많다면?
				size--; //사이즈 하나 줄여줌.
				number[array[start]]--; //배열에 해당하는 부분의 수를 추가해줍니다.
				start++; //시작부분 추가.
				if(number[array[end]]+1 <= K) { //빼고나서 K에 해당하는 부분이 증가하였다면?
					size++; //사이즈 다시 증가시켜주고
					number[array[end]]++; //끝부분 다시 추가시켜주고
					end++; //end를 증가시켜줍니다.
				}
			}
			if(maxSize < size)
				maxSize = size;
		}
		System.out.println(maxSize);
	}
}