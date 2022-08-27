import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int X;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		cut();
		System.out.println(sb);
	}
	static void cut() {
		int length = 64; //처음에 64cm인 막대
		while(X<length) { //작으면 다 자름.
			length /=2;
		}
		if(X==length) { //만약 잘랐을때 바로 길이가 같다면?
			sb.append(1); //1개의 막대기만 있으면되므로 1을 추가시켜줌.
			return; //그러고 함수를 끝내준다.
		}else {
			int sum = length; //X와 맞추기 위한 길이.
			int cnt = 1; //처음에는 1개 있으므로 더해줌
			while(sum!=X) { //같아질때까지 더함.
				sum += (length/2); //현재 있는 것과 절반 자른것을 더함.
				cnt++; //잘라준것을 더해줬으니 하나 풀로 붙인것 1개 추가.
				if(sum <= X) { //만약 더해준것이 아직 X의 길이에 도달하지 못했다면
					length /= 2; //붙여줄 막대를 마저 잘라준다.
				}else {
					sum = sum - (length/2); //만약 더 크다면 잘못 붙인것이므로 다시 length/2만큼 빼주고
					length /= 2; //막대를 반으로 자르고
					cnt--; //잘못 붙였으므로 개수를 1개 빼준다.
				}
			}
			sb.append(cnt);
		}
	}
}