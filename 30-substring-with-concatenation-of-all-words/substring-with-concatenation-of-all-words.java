import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int n = s.length();
        int wordCount = words.length;      // Array use .length
        int wordLen = words[0].length();   // String use .length()
        int totalLen = wordCount * wordLen;

        // 1. Build frequency map for the words array
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // 2. Sliding window over different possible offsets (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentMap = new HashMap<>();

            while (right + wordLen <= n) {
                // Get the next word from the right
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If we have more occurrences of 'word' than needed, shrink from left
                    while (currentMap.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If count matches total word count, we found a valid index
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Not a valid word, reset the window and move 'left' to 'right'
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}
