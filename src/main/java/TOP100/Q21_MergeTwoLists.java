package TOP100;

/**
 * @author xushu
 * @create 5/20/21 3:02 PM
 * @desc
 */
public class Q21_MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode last = null;
        ListNode oneRight = l1.next, twoRight = l2.next;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                l1.next = l2;
                if(last != null) last.next = l1;
                last = l1;

                l1 = oneRight;
                if(oneRight != null) oneRight = oneRight.next;
            }else {
                l2.next = l1;
                if(last != null) last.next = l2;
                last = l2;

                l2= twoRight;
                if(twoRight != null) twoRight = twoRight.next;
            }
        }

        if(l1 != null){
            last.next = l1;
        }
        if(l2 != null){
            last.next = l2;
        }

        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        System.out.println(new Q21_MergeTwoLists().mergeTwoLists(l1, l4));
    }
}
