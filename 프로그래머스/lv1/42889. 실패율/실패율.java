import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
       int human[] = new int[N+1]; 
		for(int i = 0; i < stages.length; i++) {
			if(stages[i] != N+1) {
				human[stages[i]]++;				
			}
		}
		double sum = 0;
		double tempanswer[][] = new double[N+1][2];
		for(int i = 1; i < human.length; i++) {
			if(human[i] == 0) {
				tempanswer[i][0] = 0;
				tempanswer[i][1] = i;
			}else {
				double percentage = (double)human[i] / ((double)stages.length-sum);
				tempanswer[i][0] = percentage;
				tempanswer[i][1] = i;
				sum += human[i]; 				
			}
		}
		Arrays.sort(tempanswer, new Comparator<double[]>() {
			
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o2[0], o1[0]);
			}
			
		});
		int cnt = 0;
		int answer[] = new int[N];
		for(int i = 0; i < N+1; i++) {
			if(tempanswer[i][1]!=0) {
				int grade = (int)tempanswer[i][1];
				answer[cnt++] = grade;
			}
		}
        return answer;
    }
}