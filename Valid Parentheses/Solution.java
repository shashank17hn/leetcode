/**
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0 ; i< s.length(); i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else if(!stack.empty() && ( (s.charAt(i) == '}' && stack.peek() == '{' )||(s.charAt(i) == ']' && stack.peek() == '[' ) || (s.charAt(i) == ')' && stack.peek() == '(' ))){
                stack.pop();
            }else {
                return false;
            }
        }
        if(stack.size() ==0 ){
            return true;
        }else{
            return false;
        }


    }
}