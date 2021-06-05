package TOP100;

/**
 * @author xushu
 * @create 5/28/21 10:40 PM
 * @desc
 */
public class Q141_HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
