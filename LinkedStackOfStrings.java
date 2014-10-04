
public class LinkedStackOfStrings {

    private Node first = null;

    @Override
    public String toString() {
        String linkedStackString = "LinkedStackOfStrings = ";
        Node current = first;
        while (current != null){
            linkedStackString += " "+ current.toString();
            current = current.next;
        }
        return linkedStackString;
    }

    private class Node {
        String item;
        Node next;

        @Override
        public String toString() {
            return item;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }
}
