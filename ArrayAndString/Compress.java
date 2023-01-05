// Write a function, compress, that takes in a string as an argument. 
// The function should return a compressed version of the string
// where consecutive occurrences of the same characters are compressed into the number of occurrences 
// followed by the character. Single character occurrences should not be changed.
// 'aaa' compresses to '3a'
// 'cc' compresses to '2c'
// 't' should remain as 't'
// You can assume that the input only contains alphabetic characters.

// Time Complexity: O(n)
// Space Complexity: O(n)
// where n = length of input string 

public class Compress {
    public static void main(String[] args) {

        String test1 = "ccaaatsss";
        System.out.println(compress(test1)); // '2c3at3s'

        String test2 = "ssssbbz";
        System.out.println(compress(test2)); // '4s2bz'

        String test3 = "nnneeeeeeeeeeeezz";
        System.out.println(compress(test3)); // '3n12e2z'
    }

    private static String compress(String str) {
        int count = 1; // to calculate number of occurrences of each char
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            count = 1;
            char currChar = str.charAt(i);

            // calculate count for curr char
            while (i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            if (count > 1) {
                result.append(String.valueOf(count));
            }
            
            result.append(currChar);
        }

        return result.toString();
    }
}

