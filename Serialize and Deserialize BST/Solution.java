/**
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        serialize(root, list);
        list.forEach(e -> sb.append(e + " "));

        return sb.toString();


    }

    private void serialize(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        serialize(root.left, list);
        serialize(root.right, list);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] dataArray = data.split(" ");
        //System.out.println("test "+ Character.getNumericValue(dataArray[0]));
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        for(int i=1; i< dataArray.length ; i++){
            deserialize(root, Integer.parseInt(dataArray[i]));
        }
        return root;
    }

    private void deserialize(TreeNode root, int val){
        if(root == null){
            return;
        }
        if(val > root.val){
            if(root.right == null){
                root.right = new TreeNode(val);
            }
            else {
                deserialize(root.right, val);
            }
        }else if(val < root.val){
            if(root.left == null){
                root.left = new TreeNode(val);
            }else {
                deserialize(root.left, val);
            }

        }

    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;