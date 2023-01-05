// Write a function, uncompress, that takes in a string as an argument.
// The input string will be formatted into multiple groups according to the following pattern:
// <number><char>
// for example, '2c' or '3a', '25kq'
// The function should return an uncompressed version of the string where
//  each 'char' of a group is repeated 'number' times consecutively.
// You may assume that the input string is well-formed according to the previously mentioned pattern.


// Time Complexity: O(nm)
// Space Compexity: O(nm)
// where n is # of groups, and m is max number for any group

public class Uncompress {
    public static void main(String[] args) {

        String test1 = "2c3a1t";
        System.out.println(uncompress(test1)); // ccaaat

        String test2 = "4s2b";
        System.out.println(uncompress(test2)); // ssssbb

        String test3 = "2p1o5p";
        System.out.println(uncompress(test3)); // ppoppppp

        String test4 = "10R1o5pA";
        System.out.println(uncompress(test4)); // RRRRRRRRRRopApApApApA


    }

    // use 2 pointers left and right recognize if number or chalacters have more than 1 digit 
    private static String uncompress(String s) {
        StringBuilder result = new StringBuilder();

        int left = 0, right = 0;

        while (right < s.length()) {
            while (Character.isDigit(s.charAt(right))) {
                right++;
            }
            String num = s.substring(left, right);
            int number = Integer.parseInt(num);
            
            left = right;
            while (right < s.length() && Character.isAlphabetic(s.charAt(right))) {
                right++;
            }
            String letters = s.substring(left, right);

            while (number > 0) {
                result.append(letters);
                number--;
            }
            left = right;
        }

        return result.toString();
    }
}
