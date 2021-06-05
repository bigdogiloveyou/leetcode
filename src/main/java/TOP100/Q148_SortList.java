package TOP100;

/**
 * @author xushu
 * @create 5/28/21 10:42 PM
 * @desc
 */
public class Q148_SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode res = new ListNode(-1);
        ListNode h = res;
        while (left != null && right != null){
            if(left.val < right.val){
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = left == null ? right : left;
        return res.next;
    }


    public void mergeSort(int[] array){
        if(array == null || array.length == 0){
            return;
        }

        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right){
        int[] help = new int[right - left + 1];

        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while(p1 <= mid && p2 <= right){
            if(array[p1] < array[p2]){
                help[i++] = array[p1++];
            }else {
                help[i++] = array[p2++];
            }
        }

        while(p1 <= mid){
            help[i++] = array[p1++];
        }

        while(p2 <= right){
            help[i++] = array[p2++];
        }

        for (int k = 0; k < help.length; k++) {
            array[k + left] = help[k];
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode res = new Q148_SortList().sortList(l1);
        while (res != null){

        }
    }
}
