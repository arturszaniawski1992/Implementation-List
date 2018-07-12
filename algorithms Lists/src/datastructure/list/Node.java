package datastructure.list;

/**
 * @author ASZANIAW 
 * Component of linked list that stores a value and reference
 * to the next element.
 */
public class Node {
	public Object data;
	public Node next;

	public Node(Object data) {
		super();
		this.data = data;

	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
