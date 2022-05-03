/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 * */

class Solution {

    public boolean validTree(int n, int[][] edges) {
        Set<Integer> nodes = new HashSet<>();
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for(int i=0 ;i<n ; i++){
            edgeMap.put(i, new ArrayList<>());
        }

        for(int i =0 ; i<edges.length ; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            edgeMap.get(n1).add(n2);
            edgeMap.get(n2).add(n1);
        }

        if(dfs(edgeMap, nodes,0, -1) && nodes.size() == n){
            return true;
        }
        return false;
    }

    private boolean dfs(Map<Integer, List<Integer>> edgeMap,  Set<Integer> nodes, int i , int prev){
        if(nodes.contains(i)){
            return false;
        }
        nodes.add(i);
        for(int e : edgeMap.get(i)){
            if(e!= prev){
                if(!dfs(edgeMap,nodes,e,i)){
                    return false;
                }
            }
        }
        return true;
    }

}

