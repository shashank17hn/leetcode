/**
 * Example 1:
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * Example 2:
 *
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 * */

class Solution {
    public int myAtoi(String s) {

        int i=0;
        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }

        if(i>=s.length()) return 0;

        int sign =1;
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            if(s.charAt(i) == '-'){
                sign =  sign * -1;
            }
            i++;
        }

        if(i>=s.length()) return 0;

        int num =0;
        System.out.println("i " + i);

        if(Character.isDigit(s.charAt(i))){
            for(int j =i;j<s.length() && Character.isDigit(s.charAt(j)); j++){
                if(num > Integer.MAX_VALUE/10 || num == Integer.MAX_VALUE/10 && Character.getNumericValue(s.charAt(j)) > Integer.MAX_VALUE%10) {
                    return (sign == 1 ) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                num = num*10 + Character.getNumericValue(s.charAt(j));
                System.out.println("num " + num  + " " + s.charAt(j));
            }
        }


        return num*sign;

    }
}