import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    // Mapping of digits to letters
    private static final Map<Character, String> KEYPAD = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Base case: if input is empty, return empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
        // If the current combination is complete
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for the current digit
        String letters = KEYPAD.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            current.append(letter);             // Add letter and move to next digit
            backtrack(result, digits, current, index + 1);
            current.deleteCharAt(current.length() - 1); // Backtrack: remove last letter
        }
    }
}
