/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 * */

class Solution {
    Stack<String> stack = new Stack<>();
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0,0);
        return ans;
    }

    private void helper(int n ,int open , int close ){

        if(open == n && open == close){
            StringBuilder sb = new StringBuilder();
            for(String i : stack){
                sb.append(i);
            }
            ans.add(sb.toString());
        }

        if(open<n){
            stack.push("(");
            helper(n, open+1, close);
            stack.pop();
        }

        if(close<open){
            stack.push(")");
            helper(n, open, close+1);
            stack.pop();
        }

    }
}