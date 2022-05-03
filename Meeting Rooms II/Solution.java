/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 * */

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];
        int count =0;
        int max =0;

        for(int i=0 ; i< intervals.length ; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int sIdx =0;
        int eIdx =0;
        while(sIdx < start.length && eIdx < end.length){
            if(start[sIdx]< end[eIdx]){
                count++;
                sIdx++;
                max = Math.max(count, max);
            }else{
                count--;
                eIdx++;
            }
        }

        return max;
    }
}