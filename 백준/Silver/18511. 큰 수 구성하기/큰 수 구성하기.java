import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 1~9까지 들어있는 arr을 먼저 오름차순 배열로만들고
	// N의 자릿수 만큼 for문 만들어서 굴리면 될것같은데..
	// 안되네.. for문 갯수가 일정치않음
	// 재귀로 만들면 안되나?..
	// arr을 오름차순 배열해서 앞에것 부터 꺼내와서 해보기.
	static int N;
	static int K;
	static int arr[];
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<K; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); //먼저 들어갈수 있는 수를 넣기.
		} 
		Arrays.sort(arr); //오름차순으로 만들어주어 값을 작은수부터 차례대로 비교해줌.
		compare(0); //먼저 0부터 차근차근 시작함.
		System.out.println(ans);
	}
	public static void compare(int value) { //value를 먼저 0으로 받아옴.
		if(value > N) //만약 N보다 큰수라면 그 수는 어떤수를 붙여도 N보다 크므로 재귀를 끝내준다.
			return; 
		if(ans < value) //만약 ans가 value보다 작을시에는 (즉 내가 붙인 수가 이전에 붙였던 수보다는 크고 N보다는 작을때를 의미함.)
			ans = value; //N보다 작은수중에서의 최대값을 구함.
		for(int i = 0; i<K; i++) { //K-1번만큼 for문을 돌려야함.
			compare(value*10+arr[i]); //이전에 있던값을 *10씩 해주며 일의자리에 arr[i]를 넣어주는 형식으로해준다.
		}
	}
}