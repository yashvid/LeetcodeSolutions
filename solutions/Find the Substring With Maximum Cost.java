class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[i] = i+1;
        }
        for (int i = 0; i < chars.length(); i++) {
            map[chars.charAt(i)-'a'] =  vals[i];
        }

        int max = 0;
        int sum = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int num = map[c-'a'];
            sum = Math.max(sum+num, num);
            max = Math.max(max, sum);
        }

        return max;
    }
}