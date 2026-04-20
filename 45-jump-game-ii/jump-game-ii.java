class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Iterate until the second to last element
        // (because once we reach the last element, we don't need another jump)
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point reachable from current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the range for the current jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // Optional: if we can already reach the last index, break early
                if (currentEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}
