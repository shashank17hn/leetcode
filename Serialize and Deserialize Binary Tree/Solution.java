/**
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
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
        return serializeHelper(root, new StringBuilder());
    }
    private String serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");

        } else{
            sb.append(Integer.toString(root.val));
            sb.append(",");
            serializeHelper(root.left,sb);
            serializeHelper(root.right,sb);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("data "+ data);
        List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        System.out.println(list);
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);
        return node;


    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));