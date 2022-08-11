import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		while (true) {
			cnt++;
			String n = sc.nextLine();
			String m = sc.nextLine();
			char com2[] = new char[m.length()];
			char com1[] = new char[n.length()];
			if (n.equals("END") && m.equals("END")) { //만약 둘다 END일시에 while문을 종료시킨다.
				break;
			}
			int nl = n.length(); //받아온 문자열 n의 길이
			int ml = m.length(); //받아온 문자열 m의 길이
			if (nl != ml) { //만약 두개의 길이가 다르다면 다른 단어기때문에
				System.out.println("Case " + cnt + ":" + " different"); //바로 diffrent를 출력하고 while문의 처음으로간다.
				continue;
			} else {
				for (int i = 0; i < nl; i++) { //같을시에는
					com1[i] = n.charAt(i); //문자의 각 단어별로 배열에 저장해준다.
					com2[i] = m.charAt(i);
				}
			}
			Arrays.sort(com1); //배열에 저장된 단어들을 전부 오름차순으로 나열해준다.
			Arrays.sort(com2);
			
			for (int i = 0; i < nl; i++) {
				if (com1[i]==com2[i]) { //만약 두개의 단어가 같다면
					if (i == nl - 1) { //끝까지 다 비교했을때 같으면
						System.out.println("Case " + cnt + ":" + " same"); //same을 출력.
					}
				} else { //아닐시에는
					System.out.println("Case " + cnt + ":" + " different"); //diffrent를 출력하고
					break; //for문을 끝내버린다.
				}
			}
		}
		sc.close();
	}
}