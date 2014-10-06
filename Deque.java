import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item>{
    private int size = 0;
    private Node first = null;
    private Node last = null;

    private class Node{
    	private Item item;
		private Node prev;
    	private Node next;
    }

    public Deque(){
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(Item item){
    	if (item == null){
    		throw new NullPointerException();
    	}
	    Node newNode = new Node();

	    // create new node
	    newNode.item = item;
	    newNode.prev = null;
	    newNode.next = first;
	    if (isEmpty()){
	    	last = newNode;
	    } else {
		    first.prev = newNode;
	    }
	    first  = newNode;
	    size++;
    }

    public void addLast(Item item){
    	if (item == null){
    		throw new NullPointerException();
    	}

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        newNode.prev = last;

        if (isEmpty()){
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public Item removeFirst()      {

    	// empty list
    	if (isEmpty()){
    		throw new NoSuchElementException();
    	}
    	// last element
    	Item item = first.item;
    	first = first.next;

    	size--;
    	if(isEmpty()){
            last = null;
            first = null;
        } else {
        	first.prev.next = null;
        	first.prev = null;
        }
        return item;
    }

    public Item removeLast()    {
        if (isEmpty()){
        	throw new NoSuchElementException();
        }
        Item item = last.item;
        if(size() == 1){
        	first = null;
        	last = null;
        	size--;
        	return item;
        }
        size--;
        Node oldLast = last;
        last = last.prev;

        last.next = null;
        oldLast.prev = null;

        return item;
    }

    @SuppressWarnings("hiding")
	private class DequeIterator<Item> implements Iterator<Item> {
    	Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Item next() {
			if(current == null){
				throw new NoSuchElementException();
			}
			Node oldCurrent = current;
			current = current.next;
			return (Item) oldCurrent.item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
    }

    @Override
    public Iterator<Item> iterator()   {
        return new DequeIterator<Item>();
    }

    public static void main(String[] args){
        Deque<Integer> deq = new Deque<>();
        deq.addLast(1);
        deq.addLast(2);
        deq.addLast(3);
        deq.addLast(4);
        deq.addLast(15);
        Iterator<Integer> iter = deq.iterator();
        while(iter.hasNext()){
        	System.out.println(iter.next());
        }

    }
}
