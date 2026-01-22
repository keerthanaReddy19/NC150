package graphs.dfs;

import java.util.ArrayList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        //convert to adj list
        ArrayList<ArrayList<Integer>> prereq_list = new ArrayList<>();

        for(int i= 0; i<numCourses; i++)
        {
            prereq_list.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites)
        {
            prereq_list.get(edge[1]).add(edge[0]);
        }

        //dfs cycle detection
        boolean[] visited = new boolean[prereq_list.size()];
        boolean[] occurrence = new boolean[numCourses];

        //check dfs for each component
        for(int i=0; i<numCourses; i++)
        {
            if(!visited[i])
            {
                if (dfsCycleDetection(i, prereq_list, visited, occurrence))
                    return false;
            }

        }
        return true;
    }


    public boolean dfsCycleDetection(int curr, ArrayList<ArrayList<Integer>> prereq_list, boolean visited[], boolean occurance[])
    {
        visited[curr] = true;
        occurance[curr] = true;

        for(int neighbour: prereq_list.get(curr))
        {
            if(!visited[neighbour])
            {
                if(dfsCycleDetection(neighbour, prereq_list, visited, occurance))
                {
                    return true;
                }
            }
            else if(occurance[neighbour])
            {
                return true;
            }
        }

        occurance[curr] = false;
        return false;


    }
}

