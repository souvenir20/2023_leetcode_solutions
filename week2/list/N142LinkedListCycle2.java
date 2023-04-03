import java.util.ArrayList;
import listnode.Listnode;
public class N142LinkedListCycle2 {
    public Listnode detectCycle(Listnode head) {
        if(head == null){
            return null;
        }
        ArrayList<Listnode> list = new ArrayList<>();
        while(head != null){
            if(list.contains(head)){
				int i = list.indexOf(head);
                return list.get(i);
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }
}