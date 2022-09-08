import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int select = Integer.parseInt(br.readLine());
		List<String> li = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			if(i%2==0) {
				li.add("뻔");				
			}else {
				li.add("데기");
			}
		}
		for(int i = 4; i<=5; i++) {
			li.add("뻔");
		}
		for(int i = 6; i<=7; i++) {
			li.add("데기");
		}
		int cnt = 0;
		int curi = 0;
		int add = 0; //뻔데기 추가.
		int length = 7;
		for(int i = 0; ; i++) {
			if(i==A)
				i = 0;
			if(cnt==T) {
				if(i>A)
					i = i%A;
				curi = i;				
			}
			if(select == 0) {
				if(li.get(add)=="뻔") {
					cnt++;
				}
			}else {
				if(li.get(add)=="데기") {
					cnt++;
				}
			}
			if(cnt==T) {
				curi = i;
				break;				
			}
			if(add==length) {
				add = 0;
				length += 2;
				li.add(4, "뻔");
				li.add(li.size()-1, "데기");
				continue;
			}
			add++;
		}
		System.out.println(curi);
	}
}