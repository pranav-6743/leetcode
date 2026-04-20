import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort to handle duplicates and allow for early pruning
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 2. Optimization: If the number is greater than the target, 
            // no need to check further because the array is sorted.
            if (candidates[i] > target) break;

            // 3. Skip duplicate elements at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            current.add(candidates[i]);
            // 4. Use i + 1 to ensure each element is used only once
            backtrack(result, current, candidates, target - candidates[i], i + 1);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
