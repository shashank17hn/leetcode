/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 * */

class Solution {
    List<Integer> result;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> course = new HashMap<>();
        for(int i =0 ; i<numCourses; i++){
            course.put(i, new ArrayList<>());
        }
        for(int i=0 ; i< prerequisites.length ; i++){
            course.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Set<Integer> completed = new HashSet<>();
        for(int i=0 ; i< numCourses ; i++){
            if(!helper(course,new HashSet<>(),completed,i)){
                return new int[0];
            }
        }
        int ans[] = new int[result.size()];
        int index =0;
        System.out.println(completed);
        for(int i : result){
            ans[index] = i;
            index++;
        }
        return ans;

    }

    private boolean helper(Map<Integer, ArrayList<Integer>> course , Set<Integer> visited , Set<Integer> completed ,int current){
        if(completed.contains(current)){
            return true;
        }
        if(visited.contains(current)){
            return false;
        }

        visited.add(current);
        for(int pre : course.get(current)){
            if(!helper(course,visited,completed,pre)){
                return false;
            }
        }
        visited.remove(current);
        completed.add(current);
        result.add(current);
        return true;
    }
}