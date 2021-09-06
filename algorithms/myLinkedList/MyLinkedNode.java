package algorithms.myLinkedList;

public class MyLinkedNode<T>
{
    private T data;
    private MyLinkedNode next;

    public MyLinkedNode(T data, MyLinkedNode next)
    {
        this.data = data;
        this.next = next;
    }

    public T data()
    {
        return data;
    }

    public MyLinkedNode next()
    {
        return next;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public void setNext(MyLinkedNode next)
    {
        this.next = next;
    }
}
