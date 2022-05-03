/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i =0 ; i< numCourses ; i++){
            courseMap.put(i, new ArrayList<Integer>());
        }
        for(int[] i: prerequisites){
            if(courseMap.containsKey(i[1])){
                courseMap.get(i[1]).add(i[0]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i[0]);
                courseMap.put(i[1], list);
            }
        }
        System.out.println(courseMap);

        for(int i =0 ; i< courseMap.size(); i++){
            if(!helper(courseMap, courseMap.get(i), visited , i))
                return false;
        }
        return true;
    }

    public boolean helper(Map<Integer, List<Integer>> courseMap,List<Integer> courses, Set<Integer> visited , int currentCourse){

        if(visited.contains(currentCourse)){
            return false;
        }
        if(courses.size() ==0){
            return true;
        }
        visited.add(currentCourse);
        for(Integer i : courses){
            if(!helper(courseMap, courseMap.get(i), visited, i)){
                return false;
            }
        }
        visited.remove(currentCourse);
        courseMap.put(currentCourse, new ArrayList<>());
        return true;
    }
}