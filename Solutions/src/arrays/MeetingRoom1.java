package arrays;
import java.util.*;

public class MeetingRoom1 {
    public boolean canAttendMeetings(int[][] intervals)
    {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int prev[] = intervals[0];
        for(int i =1; i<intervals.length;i++)
        {
            if(prev[1]>=intervals[i][1])
            {
                return false;
            }
            else
            {
                prev = intervals[i];
            }
        }
        return true;


    }
}
