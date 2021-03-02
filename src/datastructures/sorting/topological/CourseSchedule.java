package datastructures.sorting.topological;

/*
https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] course = new int[numCourses];
        boolean[] visited = new boolean[prerequisites.length];
        boolean flag = true;
        if (numCourses == 0) {
            return true;

        }

        for (int[] prerequisite : prerequisites) {
            course[prerequisite[1]]++;
        }
        while (flag) {
            flag = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i]) {
                    if (course[prerequisites[i][0]] == 0) {
                        course[prerequisites[i][1]]--;
                        visited[i] = true;
                        flag = true;

                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (course[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
