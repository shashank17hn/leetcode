/**
 *
 * Input: s = ["3","4","+","2","*","7","/"]
 * Output: 2
 * Explanation: this expression evaluates to the above binary tree with expression ((3+4)*2)/7) = 14/7 = 2.
 *
 * Input: s = ["4","5","2","7","+","-","*"]
 * Output: -16
 * Explanation: this expression evaluates to the above binary tree with expression 4*(5-(2+7)) = 4*(-4) = -16.
 *
 *
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here


};

public class TreeNode extends Node {

    public String value;
    public TreeNode left, right = null;

    public TreeNode(String value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(String value) {
        this.value = value;
        left = null;
        right = null;
    }
    public int evaluate() {
        return dfs(this);
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return Integer.parseInt(root.value);
        }

        int result = 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        switch(root.value) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                result = left / right;
                break;
        }

        return result;
    }
}
/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Set<String> operations = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<TreeNode> stack = new Stack<TreeNode>();

        for(String var : postfix) {
            if(!operations.contains(var)) {
                stack.push(new TreeNode(var));
            } else {
                if(!stack.isEmpty()) {
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    stack.push(new TreeNode(var , left, right));
                }
            }
        }
        return stack.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */