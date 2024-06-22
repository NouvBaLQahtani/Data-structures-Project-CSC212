package CSC212_EProject;

public class Node<T> {

	public T data;
	public int key;
	public Node<T> next;
	
	public Node() {
		data = null;
		next = null;
	}
	
	public Node(T val) {
		data = val;
		next = null;
	}
}
