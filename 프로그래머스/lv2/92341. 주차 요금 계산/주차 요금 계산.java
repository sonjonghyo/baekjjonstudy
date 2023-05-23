import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        HashMap<String, Integer> carType = new HashMap();
		HashMap<String, Integer> totalTime = new HashMap();
		List<Integer> answer = new ArrayList();
		String recordSplit[][] = new String[records.length][3];
		String carTime[][] = new String[records.length][2];
		int sumTime[] = new int[records.length];
		int lastTime = (23 * 60) + 59; //23:59 시간을 의미함.
		for(int i = 0; i < records.length; i++) {
			recordSplit[i] = records[i].split(" ");
			carTime[i] = recordSplit[i][0].split(":");
			sumTime[i] = (Integer.parseInt(carTime[i][0]) * 60) + (Integer.parseInt(carTime[i][1]));
		}
		for(int i = 0; i < records.length; i++) {
			//In인지 Out인지 판단해줄 것
			if(recordSplit[i][2].equals("IN")) { //IN이면 
				//UID가 들어온 시간을 넣어주자.
				carType.put(recordSplit[i][1], sumTime[i]);
			}else { //만약 나가는 거라면?
				//UID가 나가는 시간 빼서 넣어주기.
				if(totalTime.get(recordSplit[i][1]) != null) {
					totalTime.put(recordSplit[i][1], totalTime.get(recordSplit[i][1]) + (sumTime[i] - carType.get(recordSplit[i][1])));					
				}else {
					totalTime.put(recordSplit[i][1], (sumTime[i] - carType.get(recordSplit[i][1])));
				}
				carType.put(recordSplit[i][1], 0);
			}
		}

		String result[][] = new String[carType.size()][2];
		int cnt = 0;
		for(Map.Entry<String, Integer> entry : carType.entrySet()) {
			if(!entry.getValue().equals(0)) { //만약 값이 0이 아니라면?
				if(totalTime.get(entry.getKey()) != null) {
					totalTime.put(entry.getKey(), totalTime.get(entry.getKey()) + (lastTime - entry.getValue()));					
				}else {
					totalTime.put(entry.getKey(), (lastTime - entry.getValue()));
				}
			}
			int myMinute = 0;
			if(totalTime.get(entry.getKey()) != null) {
				myMinute = totalTime.get(entry.getKey());
			}else {
				myMinute = lastTime - entry.getValue();
			}
			if(myMinute > fees[0]) {
				result[cnt][0] = entry.getKey();
				result[cnt][1] = String.valueOf((fees[1] +  ((int)Math.ceil(((double)myMinute-fees[0])/(double)fees[2])) * fees[3]));
			}else {
				result[cnt][0] = entry.getKey();
				result[cnt][1] = String.valueOf(fees[1]);
			}
			cnt++;
		}
		Arrays.sort(result, new Comparator<String[]>() {
          
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }			
        });
		
		for(int i = 0; i < result.length; i++) {
			answer.add(Integer.parseInt(result[i][1]));
		}
        return answer;
    }
}
