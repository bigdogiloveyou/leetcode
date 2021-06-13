package TOP100;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author xushu
 * @create 6/6/21 1:41 PM
 * @desc
 */
public class Q239_MaxSlidingWindow {

    /**
     * 超时了
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k){
            return new int[]{};
        }

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        for(int i = 0; i < k; i++){
            maxQueue.add(nums[i]);
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = maxQueue.peek();
        for(int i = k, j = 1; i < nums.length; i++, j++){
            maxQueue.remove(nums[j - 1]);
            maxQueue.add(nums[i]);
            res[j] = maxQueue.peek();
        }

        return res;
    }

    class MonotonicQueue{
        private LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n){
            while(!queue.isEmpty() && n > queue.peekLast()){
                queue.removeLast();
            }
            queue.addLast(n);
        }

        public void pop(int n){
            // pop 都是取出队首的值，即滑动窗口中的值。
            // 因为之前都有清空的动作，所以 pop 的时候要判断一下
            if(n == queue.peekFirst()){
                queue.removeFirst();
            }
        }

        public int max(){
            return queue.peekFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums == null || nums.length == 0 || nums.length < k){
            return new int[]{};
        }

        MonotonicQueue queue = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if(i < k - 1){
                queue.push(nums[i]);
                continue;
            }

            queue.push(nums[i]);
            // i - k + 1 是 res 数组的索引，也是滑动窗口的左端
            res[i - k + 1] = queue.max();
            queue.pop(nums[i - k + 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = new Q239_MaxSlidingWindow().maxSlidingWindow(new int[]{7, 2, 4}, 2);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
