import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //수의 개수
		int number[] = new int[N]; //수 N개를 담아줄 1차원 배열을 생성해줍니다.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken()); //각 수를 담아줍니다.
		}
		//수의 합으로 나타낼수 있는지 찾는 것이므로
		Arrays.sort(number); //수를 오름차순으로 정렬해줍니다.
		int count = 0; //좋은 수의 개수
		//수 하나하나 마다 좋은수 인지 확인해야하므로
		for(int i = 0; i < N; i++) { //N번 반복하면서
			int left = 0; //이분탐색을 하기위한 left와 right
			int right = N-1;
			while(true) { //i번째 수에 해당하는 수가 좋은수인지 탐색.
				//현재 i번째 위치에 있는 수로는 좋은 수를 만들수 없으므로 이동시켜줍니다.
				if(left == i) { //왼쪽과 겹친다면?
					left++; //왼쪽은 오른쪽으로 이동시켜주어야 하므로 ++
				}else if(right == i) { //오른쪽과 겹친다면?
					right--; //오른쪽은 왼쪽으로 이동시켜주어야하므로 --
				} 
				
				if(left >= right) //서로 교차가 되어서 좋은 수가 될수없다면? 
					break; //while문을 끝내줍니다.
				
				if(number[left] + number[right] > number[i]) { //만약 두수의 합이 i번째보다 크면
					right--; //수를 더 작게 해주어야하므로 right를 감소.
				}else if(number[left] + number[right] < number[i]) { //number[i]가 더 크다면?
					left++; //수를 키워주어야 하므로 left를 증가.
				}else { //두수의 합이 같다면?
					count++; //좋은수의 개수를 증가해주며
					break; //더이상 볼 필요없으므로 while문을 끝내줍니다.
				}
			}
		}
		System.out.println(count);
	}
}