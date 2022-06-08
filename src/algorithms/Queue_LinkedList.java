package algorithms;


/**
 * offer,  poll , peek , size , isEmpty
 *
 * @param <E>
 */
public class Queue_LinkedList<E> {

    static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private int size;
    private Node<E> front; // 처음
    private Node<E> rear; // 마지막


    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public void offer(E value) {

        Node<E> head = new Node(value);
        if (isEmpty()) {
            front = head;
            rear = head;
        } else {
            front.setNext(head);
            front = head;
        }
        size++;
    }


    public Object poll() {

        if (!isEmpty()) {
            Node<E> temp = rear;
            rear = rear.getNext();
            size--;
            return temp;
        }
        return null;
    }

    public Object peek() {
        if (!isEmpty()) {
            return rear;
        }
        return null;
    }

    public int size() {

        return size;
    }


    public static void main(String[] args) {
        Queue_LinkedList<Integer> queue = new Queue_LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        System.out.println(queue.size());
        System.out.println(queue.peek());

        for (int i = 0; i < 3; i++) {
            System.out.println(queue.poll());
        }

        System.out.println(queue.size);
    }
}
