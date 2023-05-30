class Solution {
    public StringBuilder solution(String s) {
        String splitS[] = s.split(" ");
        if(s.substring(s.length() - 1, s.length()).equals(" ")) {
			splitS[splitS.length-1] += " ";
	    }
        StringBuilder answer = new StringBuilder();
		for(int i = 0; i < splitS.length; i++) {
			for(int j = 0; j < splitS[i].length(); j++) {
				char currentAlpha = splitS[i].charAt(j);
				if(j == 0) {
					if(currentAlpha >= 97) {
						answer.append(Character.toUpperCase(currentAlpha));
					}else {
						answer.append(currentAlpha);
					}
				}else {
					if(currentAlpha >= 97) {
						answer.append(currentAlpha);
					}else {
						answer.append(Character.toLowerCase(currentAlpha));
					}
				}
			}
			if(i != splitS.length-1) {
				answer.append(" ");
			}
		}
        return answer;
    }
}