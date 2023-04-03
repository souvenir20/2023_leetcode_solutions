import listnode.Listnode;
public class N876MiddleOfLinkedList {
    public Listnode middleNode(Listnode head){
        if(head == null){
            return null;
        }
        Listnode slow = head;
        Listnode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

