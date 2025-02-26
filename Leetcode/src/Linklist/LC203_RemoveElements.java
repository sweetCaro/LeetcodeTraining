package Linklist;

public class LC203_RemoveElements {
    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeElements(ListNode head, int val) {
        // 设置一个虚拟的头结点
        // 为什么要设置一个虚拟头节点，因为链表中的每个“当前”节点，只能对下一个节点进行删除操作，不能自己删除自己
        // 所以如果头节点的value是val，在没有虚拟头节点的情况下无法自己删除自己
        // 同样的，在判断是否等于val时，也是判断当前节点的下一个节点的value是不是val，而不是看自己的value是不是val，因为自己不能删除自己
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
        ListNode current = head;//当前节点
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