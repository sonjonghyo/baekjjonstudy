import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Ysum = 0;
		int Msum = 0;
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
				int Ycount = 0;
				int Mcount = 0;
				int YS = S;
				int MS = S;
				if (S < 30) { // 영식이 요금제
					Ysum += 10;
				} else if (YS >= 30 && YS < 60) {
					Ysum += 20;
				} else if (YS >= 60) {
					do {
						YS = YS - 30;
						Ycount++;
					} while (YS >= 0);
					Ysum += (Ycount * 10);
				}

				if (S < 60) {
					Msum += 15;
				} else if (MS >= 60 && MS < 120) {
					Msum += 30;
				} else if (MS >= 120) {
					do {
						MS = MS - 60;
						Mcount++;
					} while (MS >= 0);
					Msum += (Mcount * 15);
				}
			}
		if (Ysum > Msum) {
			System.out.println("M" + " " + Msum);
		} else if(Ysum == Msum){
			System.out.println("Y"+" "+ "M"+ " " +Msum);
		} else {
			System.out.println("Y" + " " + Ysum);			
		}
		sc.close();
	}
}