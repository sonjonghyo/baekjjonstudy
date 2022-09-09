import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack<Double> s = new Stack<>();
	static String formula;
	static double arr[];
	static double realresult = 0.0f;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		formula = br.readLine();
		arr = new double[N];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = (double)Integer.parseInt(br.readLine());
		}
		carcul();
		System.out.println(String.format("%.2f", realresult));
	}
	public static void carcul() {
		double num1 = 0.0f;
		double num2 = 0.0f;
		double result = 0.0f;
		for(int i = 0; i<formula.length(); i++) {
			if(formula.charAt(i)=='+' || formula.charAt(i)=='-' || formula.charAt(i)=='/' || formula.charAt(i)=='*') {
				switch(formula.charAt(i)) {
				case '+':
					num2 = s.pop();
					num1 = s.pop();
					result = num1+num2;
					s.add(result);
					break;
				case '-':
					num2 = s.pop();
					num1 = s.pop();
					result = num1-num2;
					s.add(result);
					break;
				case '/':
					num2 = s.pop();
					num1 = s.pop();
					result = num1/num2;
					s.add(result);
					break;
				case '*':
					num2 = s.pop();
					num1 = s.pop();
					result = num1*num2;
					s.add(result);
					break;
				default :
					break;
				}
			} else {
				//대문자 A의 아스키코드값은 65.
				s.add(arr[(int)(formula.charAt(i)-'A')]);
			}
		}
		realresult = s.pop();
	}
}