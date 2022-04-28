/**
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
* */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalLength = nums1.length + nums2.length;
        int medianLength = totalLength/2;
        int p1 = 0;
        int p2 = 0;
        int i =0;
        boolean isEven = totalLength%2 == 0;
        System.out.println("isEven" + isEven);
        int newArr[] = new int[totalLength];

        while(i< totalLength){
            if(p1< nums1.length && p2< nums2.length){
                if(nums1[p1]< nums2[p2]){
                    newArr[i] = nums1[p1++];
                }else {
                    newArr[i] = nums2[p2++];
                }
            }else if(p1< nums1.length){
                newArr[i] = nums1[p1++];
            }else {
                newArr[i] = nums2[p2++];
            }
            i++;
        }
        if(isEven)
        {
            Arrays.stream(newArr).forEach(e -> System.out.println(e));
            int median1= newArr[newArr.length/2];
            int median2 = newArr[(newArr.length/2)-1];
            System.out.println(newArr[newArr.length/2] + " "+ newArr[(newArr.length/2)-1] + " " + 3/2);
            return ((double) median1 + (double) median2)/2;
        }
        else
            return  newArr[newArr.length/2];


    }
}