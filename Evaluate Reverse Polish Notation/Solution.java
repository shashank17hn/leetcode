/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet();
        set.add("+");
        set.add("-");
        set.add("/");
        set.add("*");
        for(int i =0 ; i<tokens.length ; i++){
            if(set.contains(tokens[i])){
                int n2 = Integer.parseInt(stack.pop());
                int n1 = Integer.parseInt(stack.pop());
                int result =0;
                switch(tokens[i]){
                    case "*":{
                        result = n1*n2;
                    }break;
                    case "+":{
                        result = n1+n2;
                    }break;
                    case "-":{
                        result = n1-n2;
                    }break;
                    case "/":{
                        result = n1/n2;
                    }break;
                }
                stack.push(Integer.toString(result));
            }else{
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());

    }
}