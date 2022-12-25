import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int sanguen[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); //상근이가 가지고 있는 숫자 카드의 개수
		sanguen = new int[N]; //카드 배열 생성
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			sanguen[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sanguen); //상근이가 가지고있는 카드를 오름차순 배열로 바꾸어줍니다.
		M = Integer.parseInt(br.readLine()); //숫자 카드에 적혀있는 정수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken()); //카드의 수를 찾고.
			//이분 탐색 시작.
			if(binarySearch(card)) { //이분탐색시 값이 true라면?(즉 상근이가 가지고 있는 카드라면)
				sb.append(1); //1을 저장해주고
			}else { //없는 카드라면
				sb.append(0); //0을 저장해줍니다.
			}
			if(i!=M-1) //마지막을 제외하곤 띄어쓰기를 저장해줍니다.
				sb.append(" ");
		}
		System.out.println(sb);
		
	}

	private static boolean binarySearch(int card) {
		int left = 0; //배열의 가장 왼쪽부터 시작.
		int right = N-1; //배열의 가장 오른쪽 부터 시작.
		while(left <= right) { //왼쪽 오른쪽이 서로 교차되는 순간 끝이납니다.(둘중하나라도 반대로가면.)
			int midIndex = (left+right) / 2; //먼저 중간 위치를 구해줍니다.
			int midValue = sanguen[midIndex]; //중간에 있는 값을 찾아줍니다.
			
			if(card < midValue) { //만약 그 값이 우리가 찾아야할 값보다 작다면
				//작다면 상근이의 카드는 정렬되어있는것이므로 왼쪽에 위치해 있으니
				right = midIndex - 1; //right를 midIndex-1의 값을 넣어줍니다.
			}else if(card > midValue) { //값이 mid에 있는 값보다 크다면?
				left = midIndex + 1; //위와 반대로 해줍니다.
			}else { //마지막으로 둘이같다면
				return true; //true를 return해줍니다.
			}
		}
		return false; //while이 끝나버린다면 false를 반환해줍니다.
	}
}