/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 *
 * Example 2:
 *
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 * */
class Solution {
    public int minCostConnectPoints(int[][] points) {

        Queue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Set<Integer> visited = new HashSet<>();
        heap.add(new int[]{0,0});
        int cost = 0;
        while(visited.size()!= points.length){
            int current[] = heap.poll();
            if(!visited.contains(current[0])){
                visited.add(current[0]);
                cost += current[1];
                for(int i = 0 ; i<points.length ; i++){
                    int x1 = points[current[0]][0];
                    int y1 = points[current[0]][1];
                    if(!visited.contains(i)){
                        int x2 = points[i][0];
                        int y2 = points[i][1];
                        int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                        heap.add(new int[]{i, dist});
                    }
                }
            }
        }
        return cost;

    }

}

// other approach but slower
//     public int minCostConnectPoints(int[][] points) {

//         Map<Integer, ArrayList<int []>> adj = new HashMap<>();
//         for(int i =0 ; i< points.length ; i++){
//             adj.put(i , new ArrayList<>());
//         }

//         for(int i=0 ; i<points.length ; i++){
//             int x1 = points[i][0];
//             int y1 = points[i][1];
//             for(int j =0 ; j< points.length ; j++){
//                     int x2 = points[j][0];
//                     int y2 = points[j][1];
//                     int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
//                     adj.get(i).add(new int[]{j, dist});
//                     adj.get(j).add(new int[]{i, dist});
//             }
//         }

//         Queue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);
//         Set<Integer> visited = new HashSet<>();
//         heap.add(new int[]{0,0});
//         int cost = 0;
//         while(!heap.isEmpty()){
//             int current[] = heap.poll();
//             if(!visited.contains(current[0])){
//                 visited.add(current[0]);
//                 cost += current[1];
//                 for(int[] neighbour : adj.get(current[0])){
//                     heap.add(new int[]{neighbour[0], neighbour[1]});
//                 }
//             }
//         }
//         return cost;

//     }