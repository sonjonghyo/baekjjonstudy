import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            String s = sc.next();
            String s2 = sc.next();
            int arr[] = new int[6];
            int idx = 0;
            for(int i = 0; i<s.length(); i++) {
                if(i%3==2) {
                    continue;
                }else {
                    arr[idx] = s2.charAt(i)-s.charAt(i);
                    idx++;
                }
            }
            int clock[] = new int[3];
            int cnt = 0;
            for(int i = 0; i<6; i++) {
                if(i%2==1) {
                    clock[cnt] += arr[i];
                    cnt++;
                    continue;
                }
                clock[cnt] += arr[i]*10;
            }
            for(int i = 0; i<3; i++) {
                if(clock[i]<0) {
                    if(i==0) {
                    	clock[i] += 24;
                    }else if(i==1) {
                    	if(clock[i-1]>0) {
                    		clock[i] += 60;
                    		clock[i-1] -= 1;	
                    	}else {
                    		clock[i-1] += 23;
                    		clock[i] += 60;
                    	}
                    }else if(i==2) {
                    	if(clock[i-1]>0) {
                    		clock[i] += 60;
                    		clock[i-1] -= 1;
                    	}else {
                    		clock[i] += 60;
                    		clock[i-1] += 60;
                    		clock[i-2] -= 1;
                    	}
                    }
                }
            }
            for(int i = 0; i<3; i++) {
            	if(i!=2) {
            		if(clock[i]<10) {
            			sb.append("0").append(clock[i]).append(":");  
            		}else {
            			sb.append(clock[i]).append(":");            		            			
            		}
            	}else {
            		if(clock[i]<10) {
            			sb.append("0").append(clock[i]);
            		}else {
            			sb.append(clock[i]);            			
            		}
            	}
            }
            if(tc!=T) 
            	sb.append("\n");
            
        }
        System.out.println(sb);
        sc.close();
    }
}