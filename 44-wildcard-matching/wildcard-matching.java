class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0, match = 0, starIdx = -1;            
        
        while (sIdx < s.length()) {
            // 1. Characters match or pattern has '?'
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {
                sIdx++;
                pIdx++;
            } 
            // 2. Pattern has '*'
            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            } 
            // 3. Last pattern was '*', but current chars don't match
            // Backtrack: assume '*' matches one more character in 's'
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                match++;
                sIdx = match;
            } 
            // 4. No match and no '*' to backtrack to
            else {
                return false;
            }
        }
        
        // Check for remaining '*' in pattern (can match empty sequence)
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        return pIdx == p.length();
    }
}
