/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * */
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack();
        Stack<Character> stack2 = new Stack();

        helper(s,stack1);
        helper(t,stack2);

        if(stack1.size() != stack2.size()){
            return false;
        }
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(!stack1.isEmpty() && !stack2.isEmpty() && stack1.pop()!= stack2.pop()){
                return false;
            }
        }

        return true;

    }

    private void helper(String s , Stack<Character> stack1){
        for(int i=0 ; i< s.length() ; i++){
            if(s.charAt(i) == '#' && !stack1.isEmpty()){
                stack1.pop();
            }else if(s.charAt(i) != '#'){
                stack1.push(s.charAt(i));
            }
        }
    }
}