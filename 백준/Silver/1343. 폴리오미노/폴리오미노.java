import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int xcount = 0; //이어지는 X의 개수
	static int A = 0; //쓸수있는 A의 개수
	static int B = 0; //쓸수있는 B의 개수
	static String board;//보드판
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = br.readLine();
		boolean flag = true; //for문을 중간에 끝낼것인지 확인해주는 변수
		for(int i = 0; i < board.length(); i++) { //보드의 길이만큼 for문을 돌려줍니다.
			if(board.charAt(i)=='.') { //만약 보드판이 현재 .이라면?
				flag = checkpo(); //폴라오미노인지 확인해주는 함수.
				//checkpo함수 다음에 .을 추가시켜주어야 순서대로 StringBuilder에 축적됩니다.
				sb.append('.'); //.을 StringBuilder에 추가시켜줍니다.
				if(!flag) { //만약 flag가 false라면 폴라오미노를 만들수없으므로.
					break;
				}
				xcount = 0; //이어질수 없으므로 끝내줍니다.
				A = 0; //둘다 초기화시켜줍니다.
				B = 0;
			}else {
				xcount++;
			}
		}
		checkpo(); //for문이 다끝나고 문장의 마지막에 남아있는 것을 처리하기 위해 한번 더 사용.
		System.out.println(sb);
	}
	private static boolean checkpo() {
		if(xcount != 0) {
			A = xcount/4;	//먼저 A는 그동안쌓인 X의 개수를 4로 나누어준 몫입니다.
			xcount -= A*4;	//xcount를 이제 A의 몫만큼 빼줍니다.
			B = xcount/2;	//B는 2개이므로 2를 나누어준 몫입니다.
			xcount -= B*2;	//마찬가지로 B의 몫만큼 빼줍니다.
			if(xcount != 0) {	//만약 다 빼주었는데 0이아니라면?
				//이 경우는 폴라오미노로 덮을수 없는 경우입니다.
				sb.delete(0, sb.length());	//sb에 쌓인것을 전부 없애주고
				sb.append(-1);	//-1을 추가해준후
				return false;	//for문을 끝내줍니다.
			}else {	//0인경우는 다 담을수 있으므로.
				for(int a = 0; a < A; a++) {
					sb.append("AAAA"); //A번만큼 반복해서 AAAA를 담아줍니다.
				}
				for(int b = 0; b < B; b++) {
					sb.append("BB"); //B번 만큼 반복해서 BB를 담아줍니다.
				}
			}
		}
		return true;
	}
}