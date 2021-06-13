package TOP100;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

/**
 * @author xushu
 * @create 6/6/21 1:55 PM
 * @desc
 */
public class Q347_TopKFrequent {

    class Num{
        private int value;
        private int frequency;

        public Num(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public boolean equals(Object obj) {
            return ((Num)obj).value == this.value;
        }
    }

    /**
     * 普通的小根堆解法
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return null;
        }

        Map<Integer, Num> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                Num n = map.get(num);
                n.frequency++;
                map.put(num, n);
            }else {
                map.put(num, new Num(num, 1));
            }
        }

        PriorityQueue<Num> priorityQueue = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o1.frequency - o2.frequency;
            }
        });

        // nlogk，比 nlogn 没快多少
        for (Integer key : map.keySet()) {
            if(priorityQueue.size() < k){
                priorityQueue.add(map.get(key));
            }else if(map.get(key).frequency > map.get(priorityQueue.peek().value).frequency){
                priorityQueue.poll();
                priorityQueue.add(map.get(key));
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < res.length; i++){
            res[i] = priorityQueue.poll().value;
        }

        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return null;
        }

        Map<Integer, Num> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                Num n = map.get(num);
                n.frequency++;
                map.put(num, n);
            }else {
                map.put(num, new Num(num, 1));
            }
        }

        // 桶排序，将 frequency 作为数组 index，value 作为数组的值
        List<Integer>[] total = new ArrayList[nums.length + 1];
        for (Integer key : map.keySet()) {
            Num num = map.get(key);
            if(total[num.frequency] == null){
                total[num.frequency] = new ArrayList<>();
            }
            total[num.frequency].add(num.value);
        }

        int[] res = new int[k];
        // 桶排序后，frequency 大的都在数组后面
        for(int i = 0, j = total.length - 1; i < k && j >= 0;j--){
            if(total[j] != null){
                for (Integer num : total[j]) {
                    if(i >= k){
                        return res;
                    }
                    res[i++] = num;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 2;
        int[] res = new Q347_TopKFrequent().topKFrequent(nums, k);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
