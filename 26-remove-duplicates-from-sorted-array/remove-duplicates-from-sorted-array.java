class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // 'i' is the pointer for the position of unique elements
        int i = 0;

        // 'j' is the scanner pointer
        for (int j = 1; j < nums.length; j++) {
            // If we find a new unique element
            if (nums[j] != nums[i]) {
                i++;           // Move unique pointer forward
                nums[i] = nums[j]; // Update the next unique spot
            }
        }

        // Return the count of unique elements (index + 1)
        return i + 1;
    }
}
