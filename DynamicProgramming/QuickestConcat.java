// Write a function, quickestConcat, that takes in a string and an array of words as arguments.
// The function should return the minimum number of words needed to build the string by
// concatenating words of the array.

// You may use words of the array as many times as needed.

// n - # of words, s - string length
// Time: O(ns), Space: O(s)

package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QuickestConcat {
    public static void main(String[] args) {
    
        // test_00
        Map<String, Integer> memo = new HashMap<>(); 
        String s = "caution";
        Set<String> words = new HashSet<>(){{
            add("ca");
            add("ion");
            add("caut");
            add("ut");
        }};
        System.out.println("test_00: " + quickestConcat(s, words, memo)); // 2

        // test_01
        memo.clear();
        s = "caution";
        words = new HashSet<>(){{
            add("ion");
            add("caut");
            add("caution");
        }};
        System.out.println("test_01: " + quickestConcat(s, words, memo)); // 1

        // test_02
        memo.clear();
        s = "respondorreact";
        words = new HashSet<>(){{
            add("re");
            add("or");
            add("spond");
            add("act");
            add("respond");
        }};
        System.out.println("test_02: " + quickestConcat(s, words, memo)); // 4

        // test_03
        memo.clear();
        s = "simchacindy";
        words = new HashSet<>(){{
            add("sim");
            add("simcha");
            add("acindy");
            add("ch");
        }};
        System.out.println("test_03: " + quickestConcat(s, words, memo)); // 3

        // test_04
        memo.clear();
        s = "simchacindy";
        words = new HashSet<>(){{
            add("sim");
            add("simcha");
            add("acindy");
        }};
        System.out.println("test_04: " +quickestConcat(s, words, memo)); // -1

        // test_05
        memo.clear();
        s = "uuuuuu";
        words = new HashSet<>(){{
            add("u");
            add("uu");
            add("uuu");
            add("uuuu");
        }};
        System.out.println("test_05: " +quickestConcat(s, words, memo)); // 2

        // test_06
        memo.clear();
        s = "rongbetty";
        words = new HashSet<>(){{
            add("wrong");
            add("bet");
        }};
        System.out.println("test_06: " +quickestConcat(s, words, memo)); // -1

        // test_07
        memo.clear();
        s = "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu";
        words = new HashSet<>(){{
            add("u");
            add("uu");
            add("uuu");
            add("uuuu");
            add("uuuuu");
        }};
        System.out.println("test_07: " +quickestConcat(s, words, memo)); // 7
    }


    private static int quickestConcat(String s, Set<String> words, Map<String, Integer> memo) {
        if (s.isEmpty()) return 0;
        if (memo.containsKey(s)) return memo.get(s);

        int minCount = Integer.MAX_VALUE;

        for (String word : words) {
            if (word.length() <= s.length()) {
                String curr = s.substring(0, word.length());
                if (word.equals(curr)) {
                    String suffix = s.substring(word.length());
                    int attempt = quickestConcat(suffix, words, memo);
                    if (attempt != -1) {
                        minCount = Math.min(minCount, attempt+1);
                    }                    
                }
            }            
        }
        memo.put(s, minCount);

        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
}
