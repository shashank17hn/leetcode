/**
 * Example 1:
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Example 2:
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,null,3,2,4,null,5,6]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null) return "x";
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void encode(Node root, StringBuilder sb){
        sb.append(root.val);
        sb.append(",");
        for(Node node : root.children){
            encode(node, sb);
        }
        sb.append("x");
        sb.append(",");
    }

    // Decodes your encoded data to tree.
    int index =0;
    public Node deserialize(String data) {
        if(data.length() ==0 )return null;
        String[] arr = data.split(",");
        return decode(arr);
    }

    private Node decode(String[] data){
        if(index<data.length){
            if(data[index].equals("x")){
                index++;
                return null;
            }

            Node node = new Node(Integer.parseInt(data[index++]));
            List<Node> children = new ArrayList<>();
            while(index < data.length){
                Node child = decode(data);
                if(child!= null){
                    children.add(child);
                }else break;
            }
            node.children = children;
            return node;
        }else {
            return null;
        }

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));