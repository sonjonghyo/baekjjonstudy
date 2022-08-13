import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char arr[] = new char[s.length()];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i);
		}
		for (int i = 0; i < s.length(); i++) {
			if (arr[i] == 'c' || arr[i] == 'd') {
				if (i + 1 <= s.length() - 1) {
					if (arr[i + 1] == '-') {
						count++;
						i++;
					} else if (arr[i] == 'c' && arr[i + 1] == '=') {
						count++;
						i++;
					} else if (arr[i] == 'd' && arr[i + 1] == 'z') {
						if (i + 2 <= s.length() - 1) {
							if (arr[i + 2] == '=') {
								count++;
								i = i + 2;
							} else {
								count = count + 3;
								i = i + 2;
							}
						} else {
							count = count + 2;
							i = i + 2;
						}

					} else {
						count++;
					}
				} else {
					count++;
				}
			} else if (arr[i] == 's' || arr[i] == 'z') {
				if (i + 1 <= s.length() - 1) {
					if (arr[i + 1] == '=') {
						count++;
						i++;
					} else {
						count++;
					}
				} else {
					count++;
				}
			} else if (arr[i] == 'l' || arr[i] == 'n') {
				if (i + 1 <= s.length() - 1) {
					if (arr[i + 1] == 'j') {
						count++;
						i++;
					} else {
						count++;
					}
				} else {
					count++;
				}
			} else if (arr[i] == '-' || arr[i] == '='){
				continue;
			} else {
				count++;
			}
		}
		System.out.println(count);
	}
}