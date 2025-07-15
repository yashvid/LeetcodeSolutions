import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num: nums){
            if(!map.containsKey(num-1) && !map.containsKey(num+1) && map.get(num) == 1){
                list.add(num);
            }
        }

        return list;
    }
}