import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Set<String> s = new HashSet<>();
		
		for(int i = 0; i<N; i++) {
			s.add(br.readLine());
		}
		String arr[] = s.toArray(new String[0]);
		int num[] = new int[arr.length]; //각 배열안에있는 단어의 길이를 받아올 배열 생성.
		for(int i = 0; i<arr.length; i++) {
			num[i] = arr[i].length();
		}
		Arrays.sort(num);
		String result[] = new String[num.length];
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				if(num[i] == arr[j].length()) {
					result[i] = arr[j];
					arr[j] = "";
					break;
				}
			}
		}
		for(int i = 0; i<result.length-1; i++) {
			for(int j = i+1; j<result.length; j++) {
				if(result[i].length() == result[j].length()) {
					for(int l = 0; l<result[i].length(); l++) {
						int com1 = result[i].charAt(l);
						int com2 = result[j].charAt(l);
						if(com1 > com2) {
							String st = result[i];
							result[i] = result[j];
							result[j] = st;
							break;
						}else if (com1 == com2){
							continue;
						}else {
							break;							
						}
					}
				}else {
					break;
				}
			}
		}
		for(int i = 0; i<result.length; i++) {
			if(i!=result.length-1) {
				sb.append(result[i]).append("\n");				
			}else {
				sb.append(result[i]);
			}
		}
		System.out.println(sb);
	}
}