package algorithms.myLinkedList;

public class MyLinkedList<T, _>
{
    private MyLinkedNode head = null;

    public void add(T elem) {
        // case 1: the list itself is empty
        // so add the elem as head node
        if(head == null){
            head = new MyLinkedNode(elem, null);
        }

        //case 2: the list is not empty
        // traverse to the end of the list
        // add the new node to current end node
        MyLinkedNode current = null;
        for(MyLinkedNode v = head; v != null; v = v.next()){
            current = v;
        }
        current.setNext(new MyLinkedNode(elem, null));
    }

    // O(N)
    public T get(int index){
        if(index<0){
            return null;
        }

        int start = 0;
        MyLinkedNode current = head;
        while(start !=index){
            current = current.next();
            start++;
        }
        final T data = (T) current.data();
        return data;
    }
}
