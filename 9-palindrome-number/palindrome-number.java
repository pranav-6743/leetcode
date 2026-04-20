class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindromes (e.g., -121)
        // 2. If the last digit is 0, the first digit must also be 0 (only possible for 0 itself)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Keep reversing the last digits of x until we reach the middle
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even-length numbers: x == reversedHalf (e.g., 1221 -> x=12, reversedHalf=12)
        // For odd-length numbers: x == reversedHalf / 10 (e.g., 121 -> x=1, reversedHalf=12)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
