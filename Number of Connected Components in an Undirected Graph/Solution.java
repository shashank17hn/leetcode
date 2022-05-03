/**
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 *
 * Return the number of connected components in the graph.
 *
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
 * Output: 1
 * */

class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> ref = new HashMap<>();

        for(int i=0 ; i<n ; i++){
            ref.put(i, new ArrayList<>());
        }

        for(int i=0 ; i<edges.length ; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            ref.get(n1).add(n2);
            ref.get(n2).add(n1);
        }

        Set<Integer> set = new HashSet<>();
        int count =0;
        for(int key : ref.keySet()){
            if(!set.contains(key)){
                count++;
                helper(key, -1, set,ref);
            }
        }
        return count;

    }

    private void helper(int key , int prev , Set<Integer> set,  Map<Integer, List<Integer>> ref){
        if(set.contains(key)){
            return;
        }

        set.add(key);
        for(int i : ref.get(key)){
            if(i!= prev)
                helper(i,key,set,ref);
        }

    }
}