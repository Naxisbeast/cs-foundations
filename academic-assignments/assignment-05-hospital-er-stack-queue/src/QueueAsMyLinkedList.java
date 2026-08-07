public class QueueAsMyLinkedList<E> {
    MyLinkedList<E> theQueue;
    private int size;

    public QueueAsMyLinkedList()
    {
        theQueue = new MyLinkedList<>();
        size = 0;
    }

    // normal enqueue (end of queue)
    public void enqueue(E newElement)
    {
        theQueue.append(newElement);
        size++;
    }

    // priority enqueue: put element at front (emergency)
    public void enqueuePriority(E newElement)
    {
        theQueue.prepend(newElement);
        size++;
    }

    // dequeue from front
    public E dequeue()
    {
        E temp = theQueue.removeFirst();
        if (temp != null) {
            size--;
            return temp;
        } else {
            return null;
        }
    }

    // peek at front without removing
    public E peek()
    {
        return theQueue.getFirst();
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
        return theQueue.toString();
    }
}
