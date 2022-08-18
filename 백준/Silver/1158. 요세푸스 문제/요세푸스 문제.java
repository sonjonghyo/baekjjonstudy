import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int result[] = new int[N];
		int idx = 0; //result배열 저장위치.
		int count = 0; //K와 숫자가 같아질시 그 수를 저장하고 arr[i]번째를 1로 만들어 더이상 볼일 없게하기위해 사용
		int c = 0; //result배열이 몇칸 차있는지 확인하는 변수
		for(int i = 0; c<N; i++) {
			if(i>=N) 
				i -= N; //만약 N보다 클시에는 N만큼빼주어 처음부터 다시 시작하게 하기.
			if(arr[i]==0) {
				count++; //만약 0이라면 아직 사용하지않은 수이므로 count를 하나 증가시킨다.
			}else {
				continue; //1일시에는 count를 유지시키고 다시 for문을 돌린다.
			}
			if(count == K) { //만약 count와 K가 같다면.
				result[idx] = i+1; //배열의 위치는 0부터시작이므로 i+1을 저장해준다.
				arr[i]++; //arr[i]번째는 확인이 되었으므로 삭제하기위해 1로만들어 준다.
				idx++; //idx를 1추가시켜 다음 result배열 순서를 옮긴다.
				count = 0; //count를 다시 0으로 초기화해서 다시 K까지 차게 만들어준다.
				c++; //c++을 해주어 N과 같아진다면 result배열이 다 찼다는 의미로 해석한다.
				continue;
			}
		}
		System.out.print("<" + result[0]);
		for(int i = 1; i<N; i++) {
			System.out.print(", "+result[i]);			
		}
		System.out.print(">");
	}
}