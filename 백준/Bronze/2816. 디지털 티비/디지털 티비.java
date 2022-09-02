import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int check = 0; //KBS1을 찾으면 1로만들어 밑의 while문을 끝내주기 위해.
	static int N;
	static List<String> li;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		li = new ArrayList<>(); //채널을 담을 목록.
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			li.add(i, br.readLine()); //리스트에 채널명을 담아준다.
		}
		channel1("KBS1");
		check = 0;
		channel2("KBS2");
		System.out.println(sb);
	}
	public static void channel1(String s) {
		while(check!=1) {
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				if(li.get(i).equals(s)) {
					for(int j = 0; j<cnt; j++) { //여태까지 내린횟수만큼
						sb.append(4); //4를 추가해준다.
					} 
					li.remove(i); //KBS1을 지우고
					li.add(0, s); //맨앞에 KBS1을 추가해준다.
					check = 1;
					break;
				}else {
					sb.append(1); //만약 KBS1이 아니라면 채널을 한칸 아래로 내려야하기때문에 1을 추가해주고
					cnt++; //나중에 올려야할 갯수인 cnt를 1더해준다.
				}
			}
		}
	}
	public static void channel2(String s) {
		while(check!=1) {
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				if(li.get(i).equals(s)) {
					for(int j = 0; j<cnt-1; j++) { //여태까지 내린횟수-1만큼 (KBS2는 KBS1아래에 있어야하므로.
						sb.append(4); //4를 추가해준다.
					} 
					li.remove(i); //KBS2을 지우고
					li.add(1, s); //2번째에 KBS1을 추가해준다.
					check = 1;
					break;
				}else {
					sb.append(1); //만약 KBS2가 아니라면 채널을 한칸 아래로 내려야하기때문에 1을 추가해주고
					cnt++; //나중에 올려야할 갯수인 cnt를 1더해준다.
				}
			}
		}
	}
}