import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long sum = 0; // 저항값
		for (int i = 2; i >= 0; i--) {
			String s = br.readLine();
			switch (s) {
			case "black":
				if (i != 0) {
					sum *= (int)Math.pow(10, i-1);
				} else {
					sum *= 1;
				}
				break;
			case "brown":
				if (i != 0) {
					sum += (int) (1 * Math.pow(10, i-1));
				} else {
					sum *= 10;
				}
				break;
			case "red":
				if (i != 0) {
					sum += (int) (2 * Math.pow(10, i-1));
				} else {
					sum *= 100;
				}
				break;
			case "orange":
				if (i != 0) {
					sum += (int) (3 * Math.pow(10, i-1));
				} else {
					sum *= 1000;
				}
				break;
			case "yellow":
				if (i != 0) {
					sum += (int) (4 * Math.pow(10, i-1));
				} else {
					sum *= 10000;
				}
				break;
			case "green":
				if (i != 0) {
					sum += (int) (5 * Math.pow(10, i-1));
				} else {
					sum *= 100000;
				}
				break;
			case "blue":
				if (i != 0) {
					sum += (int) (6 * Math.pow(10, i-1));
				} else {
					sum *= 1000000;
				}
				break;
			case "violet":
				if (i != 0) {
					sum += (int) (7 * Math.pow(10, i-1));
				} else {
					sum *= 10000000;
				}
				break;
			case "grey":
				if (i != 0) {
					sum += (int) (8 * Math.pow(10, i-1));
				} else {
					sum *= 100000000;
				}
				break;
			case "white":
				if (i != 0) {
					sum += (int) (9 * Math.pow(10, i-1));
				} else {
					sum *= 1000000000;
				}
				break;
			}
		}
		System.out.println(sum);
		br.close();
	}
}