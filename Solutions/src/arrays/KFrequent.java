package arrays;
import java.util.*;

public class KFrequent {

    /*
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
        */


    public int[] topKFrequent(int[] nums, int k)
    {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] k_freq_elements = new int[k];

        for(int i: nums)
        {
            freq.put(i ,freq.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> min_order = new PriorityQueue<>((a, b) -> Integer.compare(freq.get(a), freq.get(b)));

        for(int j: freq.keySet())
        {
            min_order.add(j);
            if(min_order.size()>k)
            {
                min_order.poll();
            }
        }

        for(int m = 0; m<k;m++)
        {
            k_freq_elements[m] = min_order.poll();
        }

        return  k_freq_elements;
    }

    }


