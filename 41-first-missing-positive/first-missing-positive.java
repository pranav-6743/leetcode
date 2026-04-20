class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. Cyclic Sort: Place each number x at index x-1
        for (int i = 0; i < n; i++) {
            // Only move nums[i] if:
            // - It's in the range [1, n]
            // - It's not already at its correct position
            // - The target position doesn't already have this value (prevents infinite loops with duplicates)
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 2. Scan the array to find the first index that doesn't match the value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. If all numbers from 1 to n are present, return n + 1
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
