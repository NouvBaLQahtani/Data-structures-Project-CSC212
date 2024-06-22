package CSC212_EProject;

public class MNode<T> {

	public int key;
	public T data;
	public MNode<T> left, right;
	
	public MNode(int k,T val) {
		key = k;
		data = val;
		left = right = null;
	}
	
	public MNode(int k, T val, MNode<T> l, MNode<T> r) {
		key = k;
		data = val;
		left = l;
		right = r;
	}	
	
}
