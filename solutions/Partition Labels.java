import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] index = new int[26];
        char[] chArr = s.toCharArray();
        for (int i=0; i<chArr.length; i++) index[chArr[i] - 'a'] = i;
        
        List<Integer> ans = new ArrayList<>();
        
        int temp = 0;
        int startIndex = 0;
        int lastIndex = 0;
        
        while (temp < chArr.length) {
            lastIndex = Math.max(lastIndex, index[chArr[temp] - 'a']);
            if (lastIndex == temp) {
                ans.add(lastIndex - startIndex + 1);
                startIndex = temp + 1;
            }
            temp++;
        }
        
        return ans;
    }
}