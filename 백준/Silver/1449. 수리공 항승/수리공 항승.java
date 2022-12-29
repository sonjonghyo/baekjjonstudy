import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //물이 새는 곳.
		int L = Integer.parseInt(st.nextToken()); //테이프의 길이
		int waterleaking[] = new int[N]; //물이 새는 곳을 저장할 배열
		st = new StringTokenizer(br.readLine());
		int max = 0; //물이 새는 곳중 가장 먼 곳.
		for(int i = 0; i < N; i++) {
			waterleaking[i] = Integer.parseInt(st.nextToken());
			if(max < waterleaking[i])
				max = waterleaking[i];
		}
		boolean check[] = new boolean[max+1];
		for(int i = 0; i < N; i++) {
			check[waterleaking[i]] = true;
		}
		Arrays.sort(waterleaking); //오름차순으로 정렬해줍니다.
		int tapelength = 0; //테이프의 길이
		int tape = 0; //테이프의 개수
		boolean checktape = false;
		for(int i = 0; i <= max; i++) {
			if(checktape) { //테이프가 붙여져 있는 상태라면?
				if(tapelength != L) { //테이프의 길이가 L까지 안늘어져있다면?
					tapelength++;
				}
				if(tapelength == L) {
					tapelength = 0; //길이 0으로 만들어줍니다.
					checktape = false; //테이프 떼버리고
				}
			}else { //붙여져 있는 상태가 아니라면?
				if(check[i])  { //물이 새는 공간이라면? 테이프를 붙여줘.
					if(tapelength == 0) { //테이프가 안붙여져있는 상태라면?
						tape++; //테이프의 개수추가
						tapelength = 1; //추가했으므로 길이 늘려줘
						checktape = true; //테이프 붙여줘
					}else { //만약 물이 새는데 테이프가 붙여질수있다면?
						tapelength++;
					}
					if(tapelength == L) { //길이가 끝이라면?
						tapelength = 0; //길이 0으로 바꿔주고
						checktape = false; //테이프를 떼줘!
					}
				}				
			}
		}
		System.out.println(tape);
	}
}