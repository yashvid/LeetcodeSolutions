import java.util.HashMap;

class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            if(hours[i]<=8){
                arr[i]=-1;
            }
            else{
                arr[i]=1;
            }
        }

        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+= arr[i];
            if(sum>0){
                ans = Math.max(ans,i+1);
            }
            else{
                if(mp.get(sum-1)!=null){
                    ans = Math.max(ans,i-mp.get(sum-1));
                }
            }
            if(mp.get(sum)==null){
                mp.put(sum,i);
            }
        }
        return ans;
    }
}