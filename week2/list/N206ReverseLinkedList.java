import listnode.Listnode;

class N206ReverseLinkedList{
	public Listnode reverseList(Listnode head){
		if(head == null){
			return null;
		}
		if(head.next == null){
			return head;
		}
		Listnode curPre = null;
		Listnode cur = head;
		Listnode curNext = head.next;
		while(cur != null){
			curNext = cur.next;
			cur.next = curPre;
			curPre = cur;
			cur = curNext;
		}
		return curPre;
	}
}
