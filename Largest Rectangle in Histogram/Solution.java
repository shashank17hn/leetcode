/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 * Input: heights = [2,4]
 * Output: 4
 * */

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int start =0;
        for(int i =0; i<heights.length ; i++){
            start =i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] temp = stack.pop();
                // start changes here
                start = temp[0];
                maxArea = Math.max(maxArea , (i-temp[0]) * temp[1]);
            }
            stack.push(new int[]{start,  heights[i]});
            // System.out.println("start -> " + start+ " i-> " + i + " -  " + stack.peek()[0] + "," +  stack.peek()[1]) ;
        }

        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            maxArea = Math.max(maxArea , (heights.length - temp[0]) * temp[1]);
        }
        return maxArea;

    }
}