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
        //不要写成return head
        //因为dummy之后的节点会在while循环中由current进行移动删除操作
        //意味着dummy.next是随时更新的全新头节点
        //而head还是指向原来的旧头节点
        //即：如果头节点没有被删除过，那return head不会有问题
        //如果头节点的值==val，要被移除，那return head就会有问题
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