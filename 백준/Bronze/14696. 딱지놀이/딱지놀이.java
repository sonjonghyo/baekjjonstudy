import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			Stack<Integer> A = new Stack<>();
			Stack<Integer> B = new Stack<>();
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int arrA[] = new int[a]; //받아올 글자의 개수
			for(int j = 0; j<a; j++) {
				arrA[j] = Integer.parseInt(st.nextToken()); //글자의 개수만큼 A배열에 저장.
			}
			Arrays.sort(arrA); //배열을 오름차순으로 정의한다. 
			for(int j =a-1; j>=0; j--) { //내림차순으로 변경하기 위해 a-1부터 시작하며
				A.add(arrA[j]); //내림차순순으로 A스택에 쌓아준다
			}
			st = new StringTokenizer(br.readLine()); //위와 같다.
			int b = Integer.parseInt(st.nextToken());
			int arrB[] = new int[b];
			for(int j = 0; j<b; j++) {
				arrB[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arrB);
			for(int j =b-1; j>=0; j--) {
				B.add(arrB[j]);
			}
			int len = Math.max(A.size(), B.size()); //둘중 더 큰사이즈를 len이라는 변수에 저장 (무승부를 파악하기 위해 사용함)
			for(int l = 0; l<100-A.size(); l++) { //원래의 제약조건에 사이즈가 100이하이므로 스택을 100까지 쌓아주는데 그 외에 0으로 만들기 위함.
				A.add(0); //쌓인 수를 제외하곤 전부 0으로 쌓아줌.
			}
			for(int l = 0; l<100-B.size(); l++) { //위와 같다.
				B.add(0);
			}
			for(int l = 0; l<100; l++) {
				if(A.get(l) > B.get(l)) { //둘중 수가 A가 먼저 더 큰게 나온다면
					System.out.println("A"); //A를 출력
					break;
				}else if(A.get(l) < B.get(l)) { //만약 B가 더 큰것이 나온다면
					System.out.println("B"); //B를 출력하고
					break;
				}else if(l == len-1 && A.get(l)==B.get(l)) { //둘다 원래사이즈의 끝까지 같는데 같다면
					System.out.println("D"); //D를 출력하게 한다.
					break;
				}
			}		
		}
	}
}