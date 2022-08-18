import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int tc = 1; tc<=TC; tc++) {
            String s = sc.next();
            int sum = 0;
            char arr[] = new char[s.length()];
            Stack<Character> st = new Stack<>();
            for(int i = 0; i<s.length(); i++) {
                arr[i] = s.charAt(i);
            }
            for(int i = 0; i<s.length(); i++) {
                if(arr[i] == '(' && arr[i+1] == ')') {
                    sum += st.size(); //현재 막대의 개수만큼 자름.
                    i++; //뒤에 )는 볼 필요가 없으므로 한번더 i를 추가해준다.
                }else if(arr[i] == '(') { //(만 있을때
                    st.push(arr[i]); //stack에 (를 추가해주어 현재 몇개의 막대가 있는지 계산.
                    sum++; //더해주는 이유는 앞의 자를때 앞의 막대의 개수가 새로 생겨난 것이므로 추가를 해주는것.
                }else if(arr[i] == ')') {
                    st.pop(); //)만 만났을시에는 막대가 줄어드므로 stack에서 쌓은 (를 하나 빼준다.
                }
            }
            System.out.println("#"+ tc + " " + sum);
        }
        sc.close();
    }
}