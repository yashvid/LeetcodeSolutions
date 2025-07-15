class Solution {
    public long minCost(int[] nums, int[] cost) {

        long l = nums[0], h = nums[nums.length - 1];
        for(int i : nums) {
            l = Math.min(l, i);
            h = Math.max(h, i);
        }
        long ans = curCost(nums, cost, nums[0]);
        while(l < h) {
            long mid = (l + h) / 2;
            long c1 = curCost(nums, cost, mid);
            long c2 = curCost(nums, cost, mid + 1);

            ans = Math.min(c1, c2);
            if(c1 < c2) {
                h = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
    private long curCost(int[] n, int[] c, long x) {

        long cost = 0;
        for(int i = 0; i < n.length; i++) {
            cost += (Math.abs(n[i] - x) * c[i]);
        }
        return cost;
    }
}