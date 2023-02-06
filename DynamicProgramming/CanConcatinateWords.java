package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanConcatinateWords {
    public static void main(String[] args) {
        // test_00
        List<String> words = new ArrayList<>(Arrays.asList("one", "none", "is"));
        System.out.println(canConcat("oneisnone", words)); // true

        // test_01
        words = new ArrayList<>(Arrays.asList("on", "e", "is"));
        System.out.println(canConcat("oneisnone", words)); // false

        // test_02
        words = new ArrayList<>(Arrays.asList("on", "e", "is", "n"));
        System.out.println(canConcat("oneisnone", words)); // true

        // test_03
        words = new ArrayList<>(Arrays.asList("is", "g", "ood", "f"));
        System.out.println(canConcat("foodisgood", words)); // true

        // test_04
        words = new ArrayList<>(Arrays.asList("santah", "hat"));
        System.out.println(canConcat("santahat", words)); // false

        // test_05
        words = new ArrayList<>(Arrays.asList("santah", "san", "hat", "tahat"));
        System.out.println(canConcat("santahat", words)); // true

        // test_06
        words = new ArrayList<>(Arrays.asList("r", "rrr", "rrrr", "rrrrrr"));
        System.out.println(canConcat("rrrrrrrrrrrrrrrrrrrrrrrx", words)); // false

        // test_07
        words = new ArrayList<>(Arrays.asList("foo", "is", "g", "ood", "f"));
        System.out.println(canConcat("fooisgood", words)); // true
    }

    private static boolean canConcat(String s, List<String> words) {
        if (s == "") return true;

        for (String word : words) {
            int indx = word.length();
            
            if (indx <= s.length()) {
                String pref = s.substring(0, indx);                
                if (pref.equals(word)) {
                    String suffix = s.substring(indx);
                    if (canConcat(suffix, words)) return true;
                }
            }
        }

        return false;
    }
}
// "oneisnone"