package twopointer;

/*
 container_area =  min_height * width;
 min_height = Math.min(height[left], height[right]);
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        if(height == null || height.length == 0)
        {
            return 0;
        }

        int left = 0;
        int len = height.length;
        int right = len-1;
        int area = 0;

        while(left<right)
        {

            int min_height = Math.min(height[left], height[right]);
            int width = right - left;

            int container_area = min_height * width;

            area = Math.max(area, container_area);

            if(height[left]<=height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return area;
    }
}
