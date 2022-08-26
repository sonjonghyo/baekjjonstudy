import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int copyarr[][] = new int[H+X][W+Y];
		for(int i = 0; i<copyarr.length; i++) { //크기가 (H+X) x (W+Y)인 배열 생성.
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<copyarr[i].length; j++) { 
				copyarr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<H; i++) { //실제 배열의 크기만큼만 for문을 돌려준다.
			for(int j = 0; j<W; j++) {
				if(i<X) { //X보다 작은 i부분은 겹쳐지지않은 곳이기 때문에 기존의 수를 그대로 추가해준다.
					sb.append(copyarr[i][j]);
					if(j!=W-1) //마지막부분은 띄어쓰기를 하지않기위해 사용.
						sb.append(" ");
					continue; //continue를 사용해 아래 if문으로 들어가지않고 다시 for문이 동작하게 해준다.
				}
				if(j>=Y) { //만약 j가 Y보다 같거나 크다면 위와는 반대로 겹쳐있는 부분이라는 뜻으로 겹쳐진 수를 빼준다.
					copyarr[i][j] -= copyarr[i-X][j-Y]; //겹쳐진 수는 X,Y만큼 이동한 것이기 때문에 i,j좌표에서 X와 Y를 빼준 위치이다.
					//위와 같이 해줘야 계속 바뀐수를 빼줄수있기때문에. (처음에 한번에 추가했더니 오류발생.)
					sb.append(copyarr[i][j]); //저장해준다.
					if(j!=W-1)
						sb.append(" ");
				}else {
					sb.append(copyarr[i][j]); //만약 Y보다 작다면 변하지 않은 수이므로 그대로 저장한다.
					if(j!=W-1)
						sb.append(" ");
				}
			}
			if(i!=H-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}