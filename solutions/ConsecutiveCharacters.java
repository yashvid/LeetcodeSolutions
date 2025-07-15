public class ConsecutiveCharacters {
   public int maxPower(String s) {
        int len = s.length();
        int maxLen = 1;
        int currLen = 1;
        char currentChar = s.charAt(0);
        for(int i = 1; i < len; i ++)
        {
            if(s.charAt(i) == currentChar) 
            {
                currLen ++;
                maxLen = Math.max(currLen, maxLen);
            }
            else
            {
                currentChar = s.charAt(i);
                currLen = 1;
            }
        }
        return maxLen;
    }
    
    public static void main(String[] args) throws Exception {
    }
}
