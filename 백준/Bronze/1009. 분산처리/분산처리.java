import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			a = a%10;
			switch(a) {
			case 1: 
				System.out.println(1);
				break;
			case 2:
				if(b%4==1) {
					System.out.println(2);
				}else if(b%4==2) {
					System.out.println(4);
				}else if(b%4==3) {
					System.out.println(8);
				}else {
					System.out.println(6);
				}
				break;
			case 3:
				if(b%4==1) {
					System.out.println(3);
				}else if(b%4==2) {
					System.out.println(9);
				}else if(b%4==3) {
					System.out.println(7);
				}else {
					System.out.println(1);
				}
				break;
			case 4:
				if(b%2==1) {
					System.out.println(4);
				}else {
					System.out.println(6);
				}
				break;
			case 5:
				System.out.println(5);
				break;
			case 6:
				System.out.println(6);
				break;
			case 7:
				if(b%4==1) {
					System.out.println(7);
				}else if(b%4==2) {
					System.out.println(9);
				}else if(b%4==3) {
					System.out.println(3);
				}else {
					System.out.println(1);
				}
				break;
			case 8:
				if(b%4==1) {
					System.out.println(8);
				}else if(b%4==2) {
					System.out.println(4);
				}else if(b%4==3) {
					System.out.println(2);
				}else {
					System.out.println(6);
				}
				break;
			case 9:
				if(b%2==1) {
					System.out.println(9);
				}else {
					System.out.println(1);
				}
				break;
			case 0:
				System.out.println(10);
				break;
			}
		}
	}
}