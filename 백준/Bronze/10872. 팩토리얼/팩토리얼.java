import java.util.Scanner;
public class Main {
	public static int pacto(int n) { //팩토리얼 함수
		if(n<=1) { //n이 1보다 작을시에 
			return 1; //1을 리턴해줌. (0! = 1이다.)
		}else {
			return n * pacto(n-1); //그 외에는 자신을 곱하고 다시 pacto함수를 이용하는데
            //n-1을하여 하나 작은수의 팩토리얼을 구해준다.
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(pacto(N));
	}
}