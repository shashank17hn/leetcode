/**
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 *
 *
 * Example 1:
 *
 * Input: num = "69"
 * Output: true
 * Example 2:
 *
 * Input: num = "88"
 * Output: true
 * Example 3:
 *
 * Input: num = "962"
 * Output: false
 * */

class Solution {
    public boolean isStrobogrammatic(String num) {

        Map<Character, Character> ref = new HashMap<>();
        ref.put('6', '9');
        ref.put('9','6');
        ref.put('8','8');
        ref.put('1','1');
        ref.put('0','0');
        char rev[] = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i =rev.length-1; i>=0 ; i-- ){
            if(ref.containsKey(rev[i])){
                rev[i] = ref.get(rev[i]);
            }else{
                return false;
            }
            sb.append(String.valueOf(rev[i]));
        }
        if(sb.toString().equals(num)){
            return true;
        }else{
            return false;
        }


    }
}