import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .values()
                .stream()
                .allMatch(v -> v <= 2);
    }
}
