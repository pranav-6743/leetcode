import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        // Base case: target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Only proceed if the candidate doesn't exceed the remaining target
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                // Stay at index 'i' because we can reuse the same element
                backtrack(result, current, candidates, target - candidates[i], i);
                // Backtrack: remove the last element added
                current.remove(current.size() - 1);
            }
        }
    }
}
