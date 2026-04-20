class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findPosition(nums, target, true);  // Search for leftmost
        result[1] = findPosition(nums, target, false); // Search for rightmost
        return result;
    }

    private int findPosition(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int pos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                pos = mid;
                // If finding first, keep looking left. If last, look right.
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }
}
