/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 *
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 * */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // dict of all nodes
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i =1 ; i<=n ; i++){
            map.put(i , new ArrayList<>());
        }

        // populate map with node and weight
        for(int i =0 ;i <times.length ; i++){
            map.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        Queue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        heap.add(new int[]{k,0});

        Set<Integer> visited = new HashSet<>();
        int t=0;

        while(!heap.isEmpty()){
            int temp[] = heap.poll();
            System.out.println(temp[0] + " " + temp[1]);
            if(visited.contains(temp[0])){
                continue;
            }else{
                System.out.println(temp[0] + " else " + temp[1]);
                visited.add(temp[0]);
                t = Math.max(t , temp[1]);
                for(int[] neighbour : map.get(temp[0])){
                    System.out.println(temp[0] + " neighbour " + neighbour[0]);
                    if(!visited.contains(neighbour[0])){
                        heap.add(new int[]{ neighbour[0] ,temp[1]+ neighbour[1]});
                    }
                }
            }
        }
        System.out.println(visited);
        if(visited.size() == n){
            return t;
        }

        return -1;


    }
}