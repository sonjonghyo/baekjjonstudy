import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
				Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i<=T; i++) {
			int N = sc.nextInt();
			String [] arr[] = new String[N][N];
			String [] arrsum[] = new String[N][N];
			for(int j = 0; j<arr.length; j++) {
				for(int z = 0; z<arr.length; z++) {
					arr[j][z] = sc.next();
					arrsum[j][z] = "";
				}
			}
		    for(int j = 0; j<arr.length; j++) {
		        for(int z = 0; z<3; z++) {
				    for(int h = 0; h<arr.length; h++) {
				    	if(z==0) {
				    		arrsum[j][z] += arr[arr.length-1-h][j];	 //h가 0일때는 이거 됨.
				    	} else if(z%2==1) {
				    		arrsum[j][z] += arr[arr.length-1-j][arr.length-1-h]; //h가 1일때
				    	} else if(z%2==0) {
				    		arrsum[j][z] += arr[h][arr.length-1-j]; //h가 2일때
				    		
				    	}
				    }
				}
		
	        }
		    System.out.println("#"+i);
		    for(int a = 0; a<arrsum.length; a++) {
		    	for(int b= 0; b<arrsum.length; b++) {
		    		 System.out.print(arrsum[a][b] + " ");
		    	}
		    	System.out.println();
		    }
		}
	}
}