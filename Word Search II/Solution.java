/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * Example 1:
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 * */
class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
    String word;
}
class Solution {

    TrieNode root = new TrieNode();

    Set<String> visited = new HashSet<>();
    List<String> ans = new ArrayList<>();

    private void addWord(String word){
        TrieNode node = root;
        for(int i=0 ; i<word.length() ;i++){
            if(!node.children.containsKey(word.charAt(i))){
                node.children.put(word.charAt(i) , new TrieNode());
            }
            node = node.children.get(word.charAt(i));
        }
        node.isWord =true;
        node.word = word;

    }

    public List<String> findWords(char[][] board, String[] words) {

        for(int i =0 ;i< words.length; i++){
            addWord(words[i]);
        }

        for(int i =0 ; i< board.length ; i++){
            for(int j=0 ; j< board[0].length; j++){
                // if(root.children.containsKey(board[i][j])){
                //  System.out.println("found " + board[i][j]);
                dfs(board,i,j, root);
                // }
            }
        }
        return ans;

    }
    private void dfs(char[][] board, int i , int j, TrieNode node){
        if(i>= board.length|| i<0 || j>= board[0].length || j<0 ){
            return;
        }

        if(!node.children.containsKey(board[i][j])){
            return;
        }
        if(board[i][j] == '#'){
            return;
        }
        node = node.children.get(board[i][j]);
        System.out.println(node.word + " "+ node.isWord);
        if(node.isWord){
            ans.add(node.word);
            node.isWord = false;
            node.word = null;
        }
        char letter =  board[i][j] ;
        board[i][j] = '#';
        // visited.add(Integer.toString(i) + Integer.toString(j));
        dfs(board, i+1 , j, node);
        dfs(board, i-1 , j, node);
        dfs(board, i , j+1, node);
        dfs(board, i , j-1, node);
        // visited.remove(Integer.toString(i) + Integer.toString(j));
        board[i][j] =letter ;
    }
}