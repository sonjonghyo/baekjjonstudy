import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		for(int tc = 0; tc < N; tc++) {
			LinkedList<Character> lList = new LinkedList<>();
			ListIterator<Character> li = lList.listIterator();
			String secretPassword = br.readLine();
			for(int i = 0; i < secretPassword.length(); i++) {
				if(secretPassword.charAt(i) == '<') {
					if(li.hasPrevious()) {
						li.previous();
					}
				}else if(secretPassword.charAt(i) == '-') {
					if(lList.size() != 0) {
						if(li.hasPrevious()) {
							li.previous();					
							li.remove();
						}
					}
				}else if(secretPassword.charAt(i) == '>') {
					if(li.hasNext()) {
						li.next();
					}
				}else {
					li.add(secretPassword.charAt(i));
				}
			}
			for(char ch : lList) {
				result.append(ch);
			}
			if(tc != N-1) {
				result.append("\n");
			}
		}
		System.out.println(result);
	}
}