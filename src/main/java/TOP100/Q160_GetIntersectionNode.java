package TOP100;

/**
 * @author xushu
 * @create 6/5/21 1:39 PM
 * @desc
 */
public class Q160_GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode indexA = headA;
        ListNode indexB = headB;

        while(indexA != null && indexB != null){
            indexA = indexA.next;
            indexB = indexB.next;
        }

        if(indexA != null){
            indexB = headA;

            while(indexB != null){
                indexB = indexB.next;
                indexA = indexA.next;
                if(indexA == null){
                    indexA = headB;
                }

                if(indexA == indexB){
                    return indexA;
                }
            }
        }

        if(indexB != null){
            indexA = headB;

            while(indexA != null){
                indexA = indexA.next;
                indexB = indexB.next;
                if(indexB == null){
                    indexB = headA;
                }

                if(indexA == indexB){
                    return indexA;
                }
            }
        }


        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        ListNode l6 = new ListNode(7);
        l6.next = l3;

        ListNode listNode = new Q160_GetIntersectionNode().getIntersectionNode(l1, l6);
        System.out.println(listNode.val);
    }
}
