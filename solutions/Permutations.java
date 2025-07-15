import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        backtrack(0,nums,ans);
        return ans;
        }
        public static void backtrack(int start,int[] nums,List<List<Integer>>ans){
            if(start==nums.length) {
            List<Integer> permutation=new ArrayList<>();
            for(int num:nums) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
            }
            for(int i=start;i<nums.length;i++){
                swap(nums,start,i);
                backtrack(start+1,nums,ans);
                swap(nums,start,i);
            }
        }
        private static void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}