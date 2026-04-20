import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        // Map to store the last seen index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 'left' and 'right' define the sliding window
        for (int right = 0, left = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in the window, move 'left'
            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left);
            }
            
            // Update the character's last seen position
            map.put(currentChar, right);
            // Calculate window size and update max
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
