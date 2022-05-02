/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * */

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int i=0;
        while(i<intervals.length && intervals[i][1]< newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        // by using above loop all smaller intervals are already encountered now look for intersections
        while(i<intervals.length && newInterval[1] >= intervals[i][0]){
            newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]) , Math.max(newInterval[1], intervals[i][1])};
            i++;
        }
        list.add(newInterval);

        while(i<intervals.length){
            list.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[list.size()][2];

        for(int j=0 ; j< list.size() ; j++){
            ans[j] = list.get(j);
        }
        return ans;
    }

}