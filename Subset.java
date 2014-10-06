
public class Subset {
	public static void main(String [] args){
		int x = Integer.parseInt(args[0]);
		RandomizedQueue<String> queue = new RandomizedQueue<>();
		while (!StdIn.isEmpty()){
			queue.enqueue(StdIn.readString());
		}
		for(int i = 0; i < x; i++){
			StdOut.println(queue.dequeue());
		}
	}
}
