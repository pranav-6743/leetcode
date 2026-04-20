import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort to keep duplicate elements together
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element at this index is already used
            if (used[i]) continue;

            // 2. Skip duplicates:
            // If current element is the same as previous, and the previous 
            // has NOT been used in the current path, skip this one to avoid 
            // generating the same permutation twice.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.add(nums[i]);
            
            backtrack(result, current, nums, used);
            
            // Backtrack
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
