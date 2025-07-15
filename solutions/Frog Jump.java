import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean canCross(int[] stones) {

       // int n = stones.length;
        HashMap<Integer, HashSet<Integer>> path = new HashMap<>();

        for (int stone : stones) {
            path.put(stone, new HashSet<>());
        }

        return goFrog(stones[0], 0, path, stones);
    }

    private boolean goFrog(int currentStone, int lastJump, HashMap<Integer, HashSet<Integer>> path, int[] stones) {
        if (currentStone == stones[stones.length - 1])
            return true;

        for (int i = -1; i <= 1; i++) {
            int nextJump = lastJump + i;
            int nextStone = currentStone + nextJump;
            if (nextJump > 0 && path.containsKey(nextStone) && !path.get(currentStone).contains(nextJump)) {
                path.get(currentStone).add(nextJump);
                if (goFrog(nextStone, nextJump, path, stones))
                    return true;
            }
        }
        return false;
    }
}