package yuan.java.basic.demo.sample.mutilthread.base;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by yuanxin on 17/7/28.
 */
public class ConcurrentStack<E>
{

    AtomicReference<Node<E>> top = new AtomicReference<>();

    public void push(E item)
    {
        // create a new Node
        Node<E> newHead = new Node<>(item);
        Node<E> oldHead;
        do
        {
            oldHead = top.get();
            newHead.next = oldHead;
        } while (!top.compareAndSet(oldHead, newHead));
    }

    public E pop()
    {
        Node<E> oldHead;
        Node<E> newHead;
        do{
            oldHead = top.get();
            if(oldHead == null){
                return null;
            }
            newHead = oldHead.next;
        }while(! top.compareAndSet(oldHead,newHead));
        return oldHead.item;
    }

    private static class Node<E>
    {
        public final E item;

        public Node<E> next;

        public Node(E item)
        {
            this.item = item;
        }
    }
}
