import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T; tc++) { //테스트 케이스만큼 돌게 만들었습니다.
			String s = br.readLine(); //먼저 문자열을 받아오며
			for(int i = 0; i<s.length(); i++) { //그 문자열의 길이만큼 for문을 돌게 하였으며
				if(s.charAt(i)==' ' || i==s.length()-1) { //만약 빈칸이거나 마지막 부분이라면?
					if(i==s.length()-1) //만약 마지막 부분이라면 그 마지막 단어를 추가시켜주어야하므로 조건을 걸어줌.
						sb.append(s.charAt(i)); //마지막 부분일시 마지막 단어 추가.
					sb.reverse(); //안에 누적된 단어를 stringbuilder내부함수인 reverse를 사용하여 뒤집어 줍니다.
					String rs = sb.toString(); //rs라는 문자열에 뒤집어진 단어를 넣습니다.
					result.append(rs); //결과를 보여줄 result에 추가 시켜줍니다.
					sb.delete(0, sb.length()); //이전에 사용했던 sb는 다음단어가 들어갈때 비어져있어야하므로 delete라는 내부함수를 이용해 처음부터 sb의 길이까지 전부 비워내줍니다.
					if(i!=s.length()-1) //만약 마지막부분이라면 띄어쓰기가 없어야하므로 사용해 주었습니다.
						result.append(" ");
				}else { //띄어쓰기부분이 아니거나 문자의 마지막 부분이 아니라면
					sb.append(s.charAt(i)); //뒤집어질 문자에 추가해줍니다.
				}
			}
			if(tc!=T-1) //테스트케이스의 마지막부분은 띄어쓰기가 없으므로 조건을 추가해 개행문자를 넣어줍니다.
				result.append("\n");
		}
		System.out.println(result);  //결과를 출력해줍니다.
	}
}