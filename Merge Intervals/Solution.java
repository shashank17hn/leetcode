/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * */

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (a,b)->a[0]- b[0]);

        int temp[] = new int[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        for(int i =0 ; i< intervals.length-1 ; i++){

            if(temp[1] >= intervals[i+1][0] && temp[0] <= intervals[i+1][0] ){
                temp[1] =  Math.max(intervals[i+1][1], temp[1]);
            }
            else{
                System.out.println("val else "+  temp[0] + " "+ temp[1]);

                result.add(temp.clone());
                temp[0] = intervals[i+1][0];
                temp[1] = intervals[i+1][1];
            }
        }
        result.add(temp.clone());
        int index =0;
        int[][] arr = new int[result.size()][2];
        for(int[] i: result){
            arr[index][0] = i[0];
            arr[index][1] = i[1];
            index++;
        }

        return arr;

    }
}