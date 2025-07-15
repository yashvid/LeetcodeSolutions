class Solution {
    public int longestContinuousSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1] + 1) {
                maxLength = Math.max(maxLength, ++currentLength);
            } else {
                currentLength = 1;
            }
        }

        return maxLength;
    }
}