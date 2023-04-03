import listnode.Listnode;
class N21MergeTwoSortedList{
	public Listnode mergeTwolists(Listnode list1,Listnode list2){
		Listnode list = new Listnode();
		if(list1 == null){
			list = list2;
			return list;
		}
		else if(list2 == null){
			list = list1;
			return list;
		}
		Listnode cur1 = list1;
		Listnode cur2 = list2;
		Listnode cur = list;
		while(cur1 != null && cur2 != null){
			if(cur1.val <= cur2.val){
				cur.next = cur1;
				cur = cur.next;
		       	cur1 = cur1.next;		
			}
			else{
				cur.next = cur2;
				cur = cur.next;
				cur2 = cur2.next;
			}
		}
		if(cur1 == null){
			cur.next = cur2;
			return list.next;
		}
		cur.next = cur1;
		return list.next;
	}
}
