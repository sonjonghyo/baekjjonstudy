import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
			for(int i = 0; i<8; i++) {
				String chess = sc.next();
				for(int j = 0; j<8; j++) {
					if(chess.charAt(j)=='F' && (i+j)%2==0) {
						count++;						
					} else {
					continue;					
				}
			}
		}
			System.out.println(count);
	}
}