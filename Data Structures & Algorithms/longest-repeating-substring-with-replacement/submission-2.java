class Solution {
    public int characterReplacement(String s, int k) {
	if(s.length() == 0){
		return 0;
}
	int left = 0;
	int right = 0;
	int [] map = new int[26];
	int maxCount = 1;
	char maxChar = s.charAt(0);
	map[s.charAt(0) - 'A'] = 1;
	while(right<s.length()){
		if(map[s.charAt(right) - 'A'] >= map[maxChar - 'A']){
			maxChar = s.charAt(right);
			maxCount = Math.max(maxCount, map[maxChar - 'A']);
		}
        if(map[maxChar -'A']  + k >= right - left + 1){
			right++;
			if(right < s.length())
				map[s.charAt(right) - 'A'] ++;
		}
		else{
			map[s.charAt(left) - 'A']--;
			left++;
		}
}
	return Math.min(maxCount+k, s.length());
}
}

