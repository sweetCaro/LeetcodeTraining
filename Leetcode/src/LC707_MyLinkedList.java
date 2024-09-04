
public class LC707_MyLinkedList {
    int size;
    ListNode head=new ListNode();//哑节点

    public static class ListNode{
        int val;
        ListNode next;//next的类型也是节点
        ListNode(){};//直接定义一个节点
        ListNode(int val){//需要节点值属性定义该节点
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    //初始化链表
    public void MyLinkedList() {
        size = 0;//方便遍历
        head = new ListNode();
    }

    public int get(int index) {
        //有待考证->没有问题！
        if(index>=size||index<0){
            return -1;
        }
        ListNode current=head.next;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        ListNode NewNode = new ListNode(val);
        NewNode.next=head.next;
        head.next=NewNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode NewNode=new ListNode(val);
//        ListNode current=new ListNode();
//        current=head.next;
//        for(int i=0;i<size;i++){
//            current=current.next;
//        }
//        current.next=NewNode;
//        size++;//别忘了！！
        ListNode current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=NewNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode NewNode=new ListNode(val);
        ListNode current=new ListNode();
        current=head;//一开始current是哑节点，current.next是真头节点
        for(int i=0;i<index;i++){
            current=current.next;
        }
        NewNode.next=current.next;
        current.next=NewNode;
        size++;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode current=new ListNode();
        current=head;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        current.next=current.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */