import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine(); //입력받을 문장.
		int cnt = 0; //단어의 개수.
		for(int i = 0; i<sentence.length(); i++) {
			if(i==0 || i==sentence.length()-1 && sentence.charAt(i) == ' ') {
				continue;
			}
			if(sentence.charAt(i)==' ') 
				cnt++;
		}
		if(sentence.length()>1) {
			System.out.println(cnt+1);			
		}else {
			if(sentence.charAt(0)!=' ') {
				System.out.println(1);
			}else {
				System.out.println(0);				
			}
		}
		sc.close();
	}
}