class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";
        
        // Generate the sequence from 2 up to n
        for (int i = 1; i < n; i++) {
            result = getNext(result);
        }
        
        return result;
    }

    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            char currentVal = s.charAt(i);
            int count = 0;
            
            // Count consecutive identical characters
            while (i < s.length() && s.charAt(i) == currentVal) {
                count++;
                i++;
            }
            
            // Append count followed by the digit
            sb.append(count).append(currentVal);
        }
        
        return sb.toString();
    }
}
