// Write a function, mostFrequentChar, that takes in a string as an argument.
// The function should return the most frequent character of the string.
// If there are ties, return the character that appears earlier in the string.

// You can assume that the input string is non-empty.

// n - string length 
// Time Complexity: O(n)
// Space Complexity: O(n)


import java.util.HashMap;

public class MostFrequentChar {
    public static void main(String[] args) {
        
        System.out.println(mostFrequentChar("bookeeper")); // e

        System.out.println(mostFrequentChar("david")); // d

        System.out.println(mostFrequentChar("abby")); // b

        System.out.println(mostFrequentChar("mississippi")); // i

        System.out.println(mostFrequentChar("potato")); // o

        System.out.println(mostFrequentChar("eleventennine")); // e

        System.out.println(mostFrequentChar("riverbed")); // r
    }

    private static char mostFrequentChar(String s) {
        char result = ' ';
        int maxCount = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            if (map.get(ch) > maxCount) {
                maxCount = map.get(ch);
                result = ch;
            }
        }

        return result;
    }
}
