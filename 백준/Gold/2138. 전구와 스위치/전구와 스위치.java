import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int changes[];
	static int original[];
	static int nochanges[];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nochanges = new int[N]; //처음바꾸고 시작
		original = new int[N]; //원본
		String s = br.readLine();
		for(int i = 0; i<N; i++) {
			nochanges[i] = s.charAt(i)-'0';
		}
		changes = nochanges.clone(); //처음 그대로 시작.
		s = br.readLine();
		for(int i = 0; i<N; i++) {
			original[i] = s.charAt(i)-'0';
		}
		changes[0] = changes[0] == 1 ? 0 : 1; //처음꺼 바꾸고 시작하는 부분.
		changes[1] = changes[1] == 1 ? 0 : 1;		
		int cnt = 0;
		int copycnt = 1; //바꿨으니 카운트 하나 증가.
		for(int i = 1; i<N; i++) {
			if(original[i-1]!=changes[i-1]) { //이전것은 더이상 직접 바꿔줄수없으므로 다음것에서 이전것을 보아 같은지 다른지 비교후 같게 만들어줌.
				change(i);
				copycnt++; //바꿔줬으니 카운트 추가
			}
			if(original[i-1]!=nochanges[i-1]) { //안바꾼것도 바꿔서 확인해봄.
				change2(i);
				cnt++;
			}
			
		}
		if(original[N-1]==nochanges[N-1]) { //마지막 부분만 확인하면된다. 마지막부분이 서로 같다면
			System.out.println(cnt); //copy카운트를 출력.
		}else if(original[N-1]==changes[N-1]) { //안바꾼것이 같다면
			System.out.println(copycnt); //cnt를 출력
		}else { //같지않다면 뽑아낼수 없는것이므로
			System.out.println(-1); //-1출력.
		}
		
	}
	public static void change(int idx) {
		if(idx+1<N) {
			changes[idx+1]=changes[idx+1] == 1 ? 0 : 1;
		}
		changes[idx] = changes[idx] == 1 ? 0 : 1;
		changes[idx-1] = changes[idx-1] == 1 ? 0 : 1;
	}
	
	public static void change2(int idx) {
		if(idx+1<N) {
			nochanges[idx+1]=nochanges[idx+1] == 1 ? 0 : 1;
		}
		nochanges[idx] = nochanges[idx] == 1 ? 0 : 1;
		nochanges[idx-1] = nochanges[idx-1] == 1 ? 0 : 1;
	}
}