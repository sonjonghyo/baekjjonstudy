import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) throws Exception {
        //구글의 도움을 많이 받았다.
        //처음에 접근했던 방식은 이중for문이라 계속 시간초과가 떠서 1중for문을 생각해봤지만 도저히 떠오르지않음.
        //이 방식은 stack에 인덱스를 쌓아가며 그 인덱스의 배열에 해당하는 부분이 현재 i가 가르키고 있는 부분보다 작다면
        //그때 발동됌. 즉 이전에 인덱스에 있는 작은수를 현재 인덱스에 있는 큰수로 전부 교체해 주는 식으로 푸셨다.
        //그러고 마지막에 바뀌지 않은 인덱스가 있다면 그 인덱스는 전부 -1로 바꾸어서 해결하심.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N]; // 원래의 수열을 담아줄 배열.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		compare();
		for(int i = 0; i<arr.length; i++) {
			sb.append(arr[i]);
			if(i!=arr.length-1)
				sb.append(" ");
		}
		System.out.println(sb);
	}

	public static void compare() {
		for (int i = 0; i < arr.length; i++) {
			while(!(s.empty()) && arr[s.peek()]<arr[i]) {
                //비어있지않고 스택에 있는 인덱스가 가르키고있는 배열의 값이 i번째 배열의 값보다 작을시 동작함.
                //그때 스택이 가르키고 있는 인덱스의 값은 i가 가르키고있는 인덱스의 값으로 변경시켜준다.
				arr[s.pop()] = arr[i];
                //계속빼주며 스택에있는 인덱스가 가르키고있는 배열의 값을 현재 i가 가르키고있는 배열의값과 계속 비교해줌.
			}
			s.push(i); //모든 인덱스를 비교해야하므로 모든 인덱스는 다 추가해준다.
		}
		while(!(s.empty())) { //만약 스택이 비어있지않다면. 즉 바뀌지 않은 인덱스가 있다면 그 인덱스는 오른쪽과 비교했을때
            // 자기가 가장 큰수였으므로 바뀌지 않은것이다. 
			arr[s.pop()] = -1; //바뀌지않았으므로 -1로 바꾸어준다.
		}
	}
}