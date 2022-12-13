import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<Integer, String> Pokemon = new HashMap<>(); //포켓몬을 담아줄 HashMap.
		HashMap<String, Integer> Pokemon2 = new HashMap<>(); //이름을 키값으로 번호가 Value인 HashMap
		//Key값으로 포켓몬의 번호를, Value의 값으로 포켓몬의 이름을 저장해줍니다.
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //포켓몬 도감에 있는 포켓몬의 수
		int M = Integer.parseInt(st.nextToken()); //내가 맞추어야 하는 문제의 수.
		for(int num = 1; num <= N; num++) {
			String name = br.readLine(); //포켓몬의 이름을 for문이 돌아갈때마다 입력을 해주어 name이라는 변수에 저장후
			Pokemon.put(num, name); //HashMap에 num을 키값으로 포켓몬의 잉름을 저장해줍니다.
			Pokemon2.put(name, num);
		}
		for(int i = 1; i<=M; i++) {  																														
			String result = br.readLine();
			if(result.charAt(0) < 65) { //처음글자가 65(아스키코드 대문자 알파벳 값)보다 작다면? (숫자를 의미함으로 포켓몬을 뽑아주면 된다.)
				int number = Integer.parseInt(result);
				sb.append(Pokemon.get(number));
			}else { //10보다 큰 수라면 알파벳이므로 Value에 있는 값으로 Key값을 찾아주어야 합니다.
				sb.append(Pokemon2.get(result));
			}
			if(i!=M) //마지막이 아니면 개행문자를 추가해줍니다.
				sb.append("\n");
		}
		System.out.println(sb);
	}
}