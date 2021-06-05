package TOP100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xushu
 * @create 5/21/21 1:56 PM
 * @desc
 */
public class Q23_MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            priorityQueue.add(list);
        }

        ListNode dummy = new ListNode();
        ListNode p = dummy;

        while(!priorityQueue.isEmpty()){
            ListNode minNode = priorityQueue.poll();
            p.next = minNode;
            p = p.next;
            if(minNode.next != null){
                priorityQueue.add(minNode.next);
            }
        }


        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
