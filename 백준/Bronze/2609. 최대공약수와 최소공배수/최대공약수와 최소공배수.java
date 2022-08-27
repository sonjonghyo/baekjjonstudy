import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		least(A, B); //최대 공약수를 구하는 함수
		maximum(A,B); //최소 공배수를 구하는 함수.
		System.out.println(sb);
	}
	static void least(int A, int B) { //유클리드 호제법을 사용함.
		int Big = 0; //큰수
		int Small = 0; //작은수 (비교해서 큰수를 작은수로 나누어야하기때문이다.)
		if(A<B) {
			Big = B;
			Small = A;
		}else {
			Big = A;
			Small = B;
		}
		int temp = 0; //비교해줄 수.
		do {
			if(Big%Small!=0) { //만약 큰수에서 작은수를 나눈 나머지가 0이아니라면
				temp = Big%Small; //두개를 나눈 나머지를 temp에 저장하고.
				Big = Small; //큰수는 작은수로 바뀌고
				Small = temp; //작은수는 나머지로 바뀌는 것을 나머지가 0이 될때까지 반복하는 것이 유클리드 호제법이다.
			}else {
				sb.append(Small).append("\n"); //나머지가 0이되면 작은수가 두 수의 최대공약수이므로 그 수를 저장해준다.
				return;
			}
		} while(true);
	}
	
	static void maximum(int A, int B) {
		int acnt = 2;
		int bcnt = 2;
		int comA = A;
		int comB = B;
		while(true) {
			if(comA==comB) { //두개의 수가 같을시에 최소공배수가 되므로
				sb.append(comA); //둘중 아무수나 추가를 해주고
				return; //함수를 끝내준다.
			}
			if(comA>comB) { //만약 comA가 comB보다 크다면
				comB = B*bcnt; //더 작은수를 먼저 수를 하나씩 늘려가며 곱해주어야하므로 처음에 2부터 곱해준다.
				bcnt++; //그러고 bcnt를 1늘려주어 다음에 더 작을시에는 원래수에서 3을 곱하게 해준다.
			}else {
				comA = A*acnt; //위와 반대이다.
				acnt++;
			}
		}
	}
}