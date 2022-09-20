import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			int s = sc.nextInt();
			if(s==2) //2도 약수이므로 2가 들어갈시에 추가해줌.
				cnt++;
			for(int a = 2; a<s; a++) { //2보다 큰 경우를 계산해서 우리가 입력한 s의 값이 증가하는 a값에 나누어 떨어지지 않을경우에만 cnt가 추가됌.
				if(s%a==0) {
					break;
				}
				if(s-1==a) { //결과적으로 a가 s-1인 바로 우리가 쓴 그 전의 수 까지 증가하였다면 소수임이 증명됌.
					cnt++;
				}
			}
		}
		System.out.println(cnt); //총 소수의 개수를 출력해준다.
		sc.close();
	}
}