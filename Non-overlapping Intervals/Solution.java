/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Example 1:
 *
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * Example 2:
 *
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * Example 3:
 *
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int output =0;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[] temp = new int[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        for(int i =1 ; i< intervals.length ; i++){
            if(temp[1] > intervals[i][0]) {
                System.out.println(temp[0] + " " + temp[1] + "- " + intervals[i][0] + " " + intervals[i][1]);
                if(temp[1] > intervals[i][1]){
                    temp[0] = intervals[i][0];
                    temp[1] =  intervals[i][1];
                }
                output++;
            }else{
                temp[0] = intervals[i][0];
                temp[1] =  intervals[i][1];
            }

        }
        return output;

    }
}