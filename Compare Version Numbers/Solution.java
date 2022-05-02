/**
 * Return the following:
 *
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 * Example 1:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 * Example 2:
 *
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: version1 does not specify revision 2, which means it is treated as "0".
 * Example 3:
 *
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
 * */

class Solution {
    public int compareVersion(String version1, String version2) {

        int count1 =0;
        int count2 =0;

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len =  Math.max(v2.length, v1.length );

        for(int i = 0 ; i < len ; i++){

            int i1 = i< v1.length ? Integer.parseInt(v1[i]) : 0;
            int i2 = i< v2.length ? Integer.parseInt(v2[i])  : 0;

            if(i1 != i2){
                if(i1 > i2){
                    return 1;
                }else return -1;
            }

        }

        return 0;


    }
}