import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//Set을 이용하여 중복 체크해 주기.
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		//내가 쓴 입력이 몇개인지 체크해주는 것.(countTokens()).
		int size = st.countTokens();
		int num = 0;
		for(int i = 0; i < size; i++) {
			num = Integer.parseInt(st.nextToken());
			//set을 이용하여 중복이 있는지 없는지 체크하기.
			if(set.add(num)) {
				sb.append(num).append(" ");
			}
		}
		System.out.println(sb);	
	}
}