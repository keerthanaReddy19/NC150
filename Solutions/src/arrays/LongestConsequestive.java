package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequestive {

        public int longestConsecutive(int[] nums) {
            //Brute Force
            //     Arrays.sort(nums);
            //     int count =1;;
            //     for(int i = 0 ; i<nums.length-1;i++)
            //     {
            //             if(nums[i]!=0 && nums[i+1]-nums[i]==1 || nums[i+1]-nums[i]==0)
            //             {
            //                 count++;
            //             }
            //     }
            //     return count;
            // }

            //O(n)
            int count;
            int max_count = 0;
            int next;
            Set<Integer> numbers = new HashSet<>();

            for(int num: nums)
            {
                numbers.add(num);
            }

            for(int num: numbers)
            {
                if(!numbers.contains(num-1))
                {
                    count = 1;
                    next = num+1;
                    while(numbers.contains(next))
                    {
                        count++;
                        next = next+1;
                    }
                    max_count = Math.max(max_count, count);
                }
            }
            return max_count;
        }
    }

