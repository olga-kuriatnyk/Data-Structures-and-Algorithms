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

    // keep track of startIndx and endIndx. staring with 0 and n-1 (n # of chars in String)
    // if start > end return 0
    // curr = end
    // creat a variable for minCount
    // while curr > start 
        // check if subString is in words 
        // if yes, add 1 to the count + make a recursive call where start=curr+1, and end=end
        // try to reset minCount (minCoiunt, result of prev call) 
    // return minCount

    // private static int quickestConcat(String s, Set<String> words) {
    //     if (s.length() == 0) return 0;

    //     int minCount = Integer.MAX_VALUE;

    //     for (int i = s.length(); i >= 0; i--) {
    //         String word = s.substring(0, i);
    //         System.out.println("word " + word);
    //         if (words.contains(word)) {
    //             System.out.println("\t start recursive call");
    //             String slice = s.substring(i);
    //             // System.out.println("post "+postfix);
    //             int attempt = 1 + quickestConcat(slice, words);

    //             minCount = Math.min(minCount, attempt);
    //         }
    //     }
    //     System.out.println(minCount);

    //     return minCount;
    // }

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
