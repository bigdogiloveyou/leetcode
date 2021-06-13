package TOP100;

/**
 * @author xushu
 * @create 6/5/21 1:41 PM
 * @desc
 */
public class Q206_ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        while(head != null){
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;

            head = temp;
        }

        return dummy.next;
    }
}
