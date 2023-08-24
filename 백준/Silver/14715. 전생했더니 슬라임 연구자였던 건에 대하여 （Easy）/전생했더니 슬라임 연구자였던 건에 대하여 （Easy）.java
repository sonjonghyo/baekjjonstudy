import java.io.*;
//마지막까지 균형을 맞춰 내려가야함(완전이진트리를 만족시켜주어야한다.)
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//cnt가 1에서 시작하는 이유는 log10의 1은 0이므로.
		int cnt = 1;
		int K = Integer.parseInt(br.readLine());
		int answer = 0;
        while (true) {
            boolean flag = true;
            for (int i = 2; i * i <= K; i++) {
                if (K % i == 0) { //아직 나눌수있다면?(즉 소수가 아니라면)
                    flag = false;
                    K /= i; //수를 계속 줄여주어야함.
                    cnt++; //높이 추가.
                    break;
                }
            }
            if (flag) { //소수가 아닌 수면 다시 while문
                break;
            }
        }

        // 완전이진트리의 높이를 구한다.
        //log2를 바로 쓸수없으니 분모로 빼기.
        answer = (int) Math.ceil(Math.log10(cnt) / Math.log10(2));
        System.out.println(answer);
	}
}