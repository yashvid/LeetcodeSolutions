class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        
        char[] chars = colors.toCharArray();
        char prevChar = '\0';

        int prevMax = 0;

        for(int i = 0; i < chars.length; i++){

            if(prevChar == chars[i]){
                totalTime = totalTime + Math.min(neededTime[i], prevMax);

                prevMax = Math.max(neededTime[i], prevMax);
            }else{
                prevMax = neededTime[i];
                prevChar = chars[i];
            }
        }
        
        return totalTime;    
    }
}