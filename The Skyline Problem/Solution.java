/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 *
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 *
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.
 * Example 2:
 *
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 * **/

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> result = new ArrayList<>();

        List<int[]> heights = new ArrayList<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);

        for(int[] i : buildings){
            heights.add(new int[] {i[0], -i[2]});
            heights.add(new int[] {i[1], i[2]});
        }

        Collections.sort(heights,(a,b)->{
            if(a[0]!=b[0]) return a[0] -b[0];
            else return a[1] -b[1];
        });

        queue.add(0);
        int prev =0;

        for(int[] h : heights){
            // System.out.println(h[0]  + " " + h[1]);
            if(h[1] < 0) queue.add(-h[1]);
            else queue.remove(h[1]);
            // System.out.println("queue " + queue);

            int curr = queue.peek();
            if(curr != prev){
                result.add(new ArrayList<>(Arrays.asList(h[0],curr)));
                prev = curr;
            }
        }

        return result;

    }
}