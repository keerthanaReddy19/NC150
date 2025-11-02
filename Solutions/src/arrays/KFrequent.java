package arrays;

import java.util.HashMap;
import java.util.PriorityQueue;

public class KFrequent {

        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            int[] result = new int[k];
            for(int num: nums)
            {
                if(!freq.containsKey(num))
                {
                    freq.put(num,1);
                }
                else
                {
                    freq.put(num,freq.get(num)+1);
                }
            }

            PriorityQueue<Integer> values = new PriorityQueue<>
                    ((a,b) -> Integer.compare(freq.get(a),freq.get(b)));

            for(int ele: freq.keySet())
            {
                values.add(ele);
                if(values.size()>k)
                {
                    values.poll();
                }
            }

            for(int i =0;i<k;i++)
            {
                result[i] = values.poll();
            }
            return result;
        }
    }


