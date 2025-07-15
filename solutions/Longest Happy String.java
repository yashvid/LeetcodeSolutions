import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        long n=nums.length;
        long goodPairs=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int diff=i-nums[i];
            goodPairs+=map.merge(diff, 1, Integer::sum)-1;
        }
        long badPairs=(n-1)*n/2-goodPairs;
        return badPairs;
    }
}