package TOP100;


import java.math.BigInteger;

/**
 * @author xushu
 * @create 5/17/21 5:04 PM
 * @desc
 */
public class Q2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;

        int up = 0;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + up;
            up = num / 10;
            num = num % 10;

            ListNode node = new ListNode(num);
            p.next = node;
            p = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int num = l1.val + up;
            up = num / 10;
            num = num % 10;

            ListNode node = new ListNode(num);
            p.next = node;
            p = node;

            l1 = l1.next;
        }

        while (l2 != null){
            int num = l2.val + up;
            up = num / 10;
            num = num % 10;

            ListNode node = new ListNode(num);
            p.next = node;
            p = node;

            l2 = l2.next;
        }

        if(up > 0){
            ListNode node = new ListNode(up);
            p.next = node;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;



        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(9);
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode res = new Q2_AddTwoNumbers().addTwoNumbers(l1, l4);
        while (res != null){
            System.out.println(res.val + ":");
            res = res.next;
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
