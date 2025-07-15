class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        int n = obstacles.length;
        int[] dp = new int[n];
        dp[0] = obstacles[0];

        int len = 1, pos = 1;
        int[] ans = new int[n];
        ans[0] = 1;

        for(int i = 1; i < n; i++) {
            int x = obstacles[i];
            if(x >= dp[len-1]) {
                dp[len++] = x;
                pos = len;
            }else{
                int l = 0, r = len - 1;
                while(l <= r) {
                    int mid = l + r >> 1;
                    if(dp[mid] <= x) {
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }

                dp[l++] = x;
                pos = l;
            }

            ans[i] = pos;
        }

        return ans;        
    }
}