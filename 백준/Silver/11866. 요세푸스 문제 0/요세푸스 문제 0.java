import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>(); //1~N까지의 수를 저장할 큐 생성.
		int storage = 0; //poll()을 사용해 빼낸수를 저장해줄 변수
		int count = 0; //count와 K를 비교하여 같을시에 storage를 출력해줌.
		for(int i = 1; i<=N; i++) {
			q.add(i); //1~N까지 큐에 저장
		}
		System.out.print("<");
		while(!(q.size()==0)) { //큐의 사이즈가 0이 될때 while문을 끝내기로함.
			count++; //바로 카운트를 올려준다(K번째를 바로 찾기위해.)
			storage = q.poll(); //빼낸 q의 첫번째수를 storage에 저장해준다. 빼냈으니 q의 첫번째는 삭제됨.
			if(count == K) { //만약 count와 K가 같다면
				if(q.size()==0) { //size가 0이라면 마지막부분이므로
					System.out.print(storage + ">"); //오른쪽꺽쇠를 붙여주고
				}else { //그 외라면
					System.out.print(storage + ", "); //쉼표 + 띄어쓰기를 해준다.					
				}
				count = 0; //그러고 다시 count를 0으로 초기화해 다시 count가 K와 비교될수있게 만들어준다.
			}
			else { //만약 count와 K가 다르다면?
				q.add(storage);		//다르다는 것은 삭제하는것이아닌 다시 저장을 해주어야하므로 add(storage)를 사용해 다시 큐에 붙여준다.	
			}
		}
	}
}