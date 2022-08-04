import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double D = sc.nextDouble();
		double H = sc.nextDouble();
		double W = sc.nextDouble();
		double a = 0; //a라는 변수 (비율 값곱할때 사용해줄 변수)
		a = (D*D)/((H*H)+(W*W)); //피타고라스의 정리 사용.
		a = Math.sqrt(a); //a의 제곱근 구하기
		int h = (int) (a*H); //실제 높이는 a에 원래 비율H를 곱해주면 된다.
		int w = (int) (a*W); //실제 높이는 a에 원래 비율W를 곱해주면 된다.
		System.out.println(h + " " + w);
		sc.close();
	}
}