package arrays;
//LC 11
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int length = height.length;

        int left = 0;
        int right = length-1;
        int max_area = 0;

        while(left<=right)
        {
            if(height[left]<=height[right])
            {
                max_area = Math.max(max_area, height[left] * (right-left));
                left++;

            }
            else
            {
                max_area = Math.max(max_area, height[right] * (right-left));
                right--;
            }
        }

        return max_area;
    }
}
