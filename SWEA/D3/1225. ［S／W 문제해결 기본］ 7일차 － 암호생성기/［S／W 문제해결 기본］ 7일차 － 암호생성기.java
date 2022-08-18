import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for (int t = 0; t < 10; t++) {
            int tc = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            int arr[] = new int[8];
            for (int i = 0; i < 8; i++) {
                q.add(sc.nextInt());
            }
            int i = 1;
            loop:
            while (true) {
                if(i==6) {
                    i = 1;
                }
                    int a = q.poll()-i;
                    if (a <= 0) {
                        a = 0;
                        q.add(a);
                        break loop;
                    } else {
                        q.add(a);
                    }
                i++;
            }
            for(int a = 0; a<arr.length; a++) {
                arr[a] = q.poll();
            }
            System.out.print("#" + tc + " ");
            for(int a = 0; a<arr.length; a++) {
                System.out.print(arr[a] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}