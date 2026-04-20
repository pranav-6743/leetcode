class Solution {
    public int removeElement(int[] nums, int val) {
        // Pointer for the position of the next valid element
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            // If the current element is NOT the value we want to remove
            if (nums[i] != val) {
                // Move it to the front of the array
                nums[k] = nums[i];
                // Increment our count of valid elements
                k++;
            }
        }

        // k is the count of elements not equal to val
        return k;
    }
}
