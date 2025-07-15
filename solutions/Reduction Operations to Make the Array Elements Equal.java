import java.util.Arrays;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, prev = -1, pos= -1;
        for (int curr: nums) {
            if (prev != curr) pos += 1;
            ans += pos;
            prev = curr;
        }
        return ans;
    }
}