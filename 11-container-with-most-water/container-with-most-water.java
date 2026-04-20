class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Area is determined by the shorter line and the distance between them
            int currentWidth = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = currentWidth * currentHeight;
            
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            // because keeping the shorter line can never produce a larger area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
