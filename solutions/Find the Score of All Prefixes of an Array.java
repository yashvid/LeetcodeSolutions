class Solution {
    public long[] findPrefixScore(int[] nums) {
       int n=nums.length;
       int max=nums[0];
       long ans=0;
       long arr[]=new long[n];
       for(int i=0;i<n;i++)
       {
          max=Math.max(max,nums[i]);
          ans+=nums[i]+max;
          arr[i]=ans;
       } 
       
       return arr;
    }
}