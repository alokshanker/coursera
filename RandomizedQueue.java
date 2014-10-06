import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item>{

	private  Item[] stack;
	private  int size = 0;

	@SuppressWarnings("unchecked")
	public RandomizedQueue(){
		stack = (Item[]) new Object[1];
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int size(){
		return size;
	}

	public void enqueue(Item item){
		if (item == null){
			throw new NullPointerException();
		}
		if (stack.length == size){
			resize(stack.length * 2);
		}
		stack[size++] = item;
	}

	public Item dequeue(){
		if (isEmpty()){
			throw new NoSuchElementException();
		}

		exch(stack, size-1, StdRandom.uniform(size));
		Item item = stack[--size];
		stack[size] = null;
		if (size > 0 && size == stack.length / 4){
			resize(stack.length / 2);
		}
		return item;
		// delete and return a random item
	}

	public Item sample(){
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		return stack[StdRandom.uniform(size)];
	}

	private class RandomizedQueueIterator<Item> implements Iterator<Item>{
		int current = 0;

		@Override
		public boolean hasNext() {
			return current < size;
		}

		@Override
		public Item next() {
			if (current >= size){
				throw new NoSuchElementException();
			}
			return (Item) stack[current++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<Item> iterator(){
		shuffle(this.stack);
		return new RandomizedQueueIterator<>();
		// return an independent iterator over items in random order
	}

	private void exch(Item[] a, int j, int i){
		Item swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private void shuffle(Item[] a){
		int N = size;
		for (int i = 0; i < N; i++){
			int r = StdRandom.uniform(i+1);
			exch(a, r, i);
		}
	}

	private void resize(int capacity)
	{
		@SuppressWarnings("unchecked")
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < size; i++){
			copy[i] = stack[i];
		}
		stack = null; /* Free it */
		stack = copy;
	}

	public static void main(String[] args){
		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.enqueue(1);
		rq.enqueue(2);
		rq.enqueue(3);
		rq.enqueue(4);
		rq.enqueue(5);

		Iterator<Integer> iter = rq.iterator();
		Iterator<Integer> iter1 = rq.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		while(iter1.hasNext()){
			System.out.println(iter1.next());
		}

	}
}

