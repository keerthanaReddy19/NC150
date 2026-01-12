package priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

/*Input: nums = [3,2,1,5,6,4], k = 2

 */
public class KthLargestElement {

    public int LargestElement(int[] nums, int k) {
        //PriorityQueue - descending order
//        Queue<Integer> order = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
//
//        for(int i: nums)
//        {
//            order.add(i);
//        }
//
//        // order = {6,5,4,3,2,1}
//
//        int i = 1;
//        while(i<k)
//        {
//            order.remove();
//            i++;
//        }
//
//       return order.remove();
//    }


        Queue<Integer> order = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for (int i : nums) {
            order.add(i);
            if (order.size() > k) {
                order.remove();

            }
        }
        return order.peek();
    }
}
