/**
 * Convert a non-negative integer num to its English words representation.
 * Example 1:
 *
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * */

class Solution {

    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num){
        String result = new String();
        if(num<10) result = belowTen[num];
        else if(num<20) result = belowTwenty[num-10];
        else if(num<100) result = belowHundred[num/10] + " " + belowTen[num%10];
        else if(num<1000) result = belowTen[num/100] + " Hundred " + helper(num%100);
        else if(num<1000000) result = helper(num/1000) + " Thousand " + helper(num%1000);
        else if(num<1000000000) result = helper(num/1000000) + " Million " + helper(num%1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num%1000000000);
        return result.trim();
    }
}