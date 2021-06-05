package TOP100;

/**
 * @author xushu
 * @create 5/20/21 2:00 PM
 * @desc
 */
public class Q19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head, end = head;
        for(int i = 0; i < n && end != null; i++){
            end = end.next;
        }

        if(end == null){
            ListNode h = head;
            head = head.next;
            h = null;
            return head;
        }

        while (end.next != null){
            start = start.next;
            end = end.next;
        }

        ListNode nextNode = start.next;
        start.next = nextNode.next;
        nextNode = null;

        return head;
    }
}
