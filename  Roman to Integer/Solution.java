/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * */

class Solution {
    public int romanToInt(String s) {
        int result = 0;

        for(int i =0 ; i< s.length() ; i++){

            if(i+1< s.length()){
                if(s.charAt(i)=='C' && s.charAt(i+1) == 'D'){
                    result = result + 400;
                    i++;
                }
                else if(s.charAt(i)=='C' && s.charAt(i+1) == 'M'){
                    result =   result + 900;
                    i++;
                }else if(s.charAt(i)=='X' && s.charAt(i+1) == 'L'){
                    result =  result + 40;
                    i++;
                }
                else if(s.charAt(i)=='X' && s.charAt(i+1) == 'C'){
                    result =  result + 90;
                    i++;
                }else if(s.charAt(i)=='I' && s.charAt(i+1) == 'V'){
                    result = result + 4;
                    i++;
                }
                else if(s.charAt(i)=='I' && s.charAt(i+1) == 'X'){
                    result = result + 9;
                    i++;
                }else {
                    result = result + getMapping(s.charAt(i));
                }
            }else {
                result = result + getMapping(s.charAt(i));
            }

        }
        return result;
    }

    private int getMapping(Character input){
        switch(input){
            case 'I':
                return 1;
            case 'V' :
                return 5;
            case 'X' :
                return 10;
            case 'L' :
                return 50;
            case 'C' :
                return 100;
            case 'D' :
                return 500;
            case 'M' :
                return 1000;
        }
        return 0;
    }
}