public class StackAsMyLinkedList<E> {
    MyLinkedList<E> theStack;
    private int size;

    public StackAsMyLinkedList()
    {
        theStack = new MyLinkedList<E>();
        size = 0;
    }

    // push to top
    public void push(E newElement)
    {
        theStack.prepend(newElement);
        size++;
    }

    // pop from top
    public E pop()
    {
        E temp = theStack.removeFirst();
        if (temp != null) {
            size--;
            return temp;
        } else {
            return null;
        }
    }

    // peek top
    public E peek()
    {
        return theStack.getFirst();
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    @Override
    public String toString()
    {
        return theStack.toString();
    }
}
