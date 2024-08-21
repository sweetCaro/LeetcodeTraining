public class LC203_RemoveLinkedListElements {
    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeElements(ListNode head, int val) {
        // 设置一个虚拟的头结点
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 6, 3, 4, 5, 6};

        ListNode head = new ListNode(numbers[0]);
        ListNode current = head;
        for (int i = 1; i < numbers.length; i++) {

            current.next = new ListNode(numbers[i]);
            current = current.next;
        }
        ListNode result = removeElements(head, 6);

        while (result != null) {//遍历链表的条件
            System.out.println(result.val);
            result = result.next;//遍历链表的操作
//        }
        }
    }
}