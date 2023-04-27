import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      HashSet<String> map = new HashSet<>();
      st = new StringTokenizer(br.readLine());
      String S = st.nextToken(); //시작시간
      String E = st.nextToken(); //끝낸시간
      String Q = st.nextToken(); //개강총회 스트리밍 끝난시간.
      String ArrayS[] = S.split(":");
      String ArrayE[] = E.split(":");
      String ArrayQ[] = Q.split(":");
      
      int cnt = 0;
      String value = "";
       while(((value = br.readLine()) != null) && !value.isEmpty()) {
            st = new StringTokenizer(value);
          String time = st.nextToken();
          String name = st.nextToken();
          String timeValue[] = time.split(":");
          if(Integer.parseInt(ArrayS[0]) > Integer.parseInt(timeValue[0])) {
             map.add(name);
             continue;
          }else if(Integer.parseInt(ArrayS[0]) == Integer.parseInt(timeValue[0])) {
             if(Integer.parseInt(ArrayS[1]) >= Integer.parseInt(timeValue[1])) {
                map.add(name);
                continue;
             }
          }else if(Integer.parseInt(ArrayE[0]) <= Integer.parseInt(timeValue[0])) {
        	if(Integer.parseInt(ArrayE[0]) == Integer.parseInt(timeValue[0])) {
        		if(Integer.parseInt(ArrayE[1]) <= Integer.parseInt(timeValue[1])) {
        			if(Integer.parseInt(timeValue[0]) < Integer.parseInt(ArrayQ[0])) {
            			if(map.remove(name)) { 
            				cnt++;
            				continue;          		
            			}   
        			}else if((Integer.parseInt(timeValue[0]) == Integer.parseInt(ArrayQ[0]))){
        				if(Integer.parseInt(ArrayQ[1]) >= Integer.parseInt(timeValue[1])) {
        	                   if(map.remove(name)) { 
        	                      cnt++;
        	                   }
        			}
        		}
        	}
        	}else {     		
        		if(Integer.parseInt(timeValue[0]) < Integer.parseInt(ArrayQ[0])) {
        			if(map.remove(name)) { 
        				cnt++;
        				continue;          		
        			}        		
        		}else if(Integer.parseInt(timeValue[0]) == Integer.parseInt(ArrayQ[0])) {
        			 if(Integer.parseInt(ArrayQ[1]) >= Integer.parseInt(timeValue[1])) {
                         if(map.remove(name)) { 
                            cnt++;
                         }
                      }
        		}
        	
                }
             }else if(Integer.parseInt(timeValue[0]) == Integer.parseInt(ArrayQ[0])) {
                if(Integer.parseInt(ArrayQ[1]) >= Integer.parseInt(timeValue[1])) {
                   if(map.remove(name)) { 
                      cnt++;
                   }
                }
             }
          }
       System.out.println(cnt);
       }
}