package datastructure.list;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author ASZANIAW
 * 
 *         List based on recursively related objects
 *
 * @param <T>
 */

public class CustomLinkedList<T> extends AbstractCustomListAdapter<T> {

	private Node root;
	private int size;
	private Node tail;
	private Node node;

	public CustomLinkedList(Node root, int size) {
		this.root = root;
		this.size = size;
	}

	public CustomLinkedList() {
		this.root = null;
		this.size = 0;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return root == null;

	}

	@Override
	public boolean contains(Object o) {
		if (root == null) {
			throw new EmptyStackException();
		}
		Node current = root;
		for (int i = 0; i < size; i++) {
			if (current.getData().equals(o)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomLinkedListIterator<>();
	}

	@Override
	public boolean add(T t) {
		if (root == null) {
			Node curr = new Node(t);
			root = curr;
			tail = curr;
		} else {
			Node tempNode = new Node(t);
			tail.next = tempNode;
			tail = tempNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (size == 0)
			return false;
		if (root.data.equals(o)) {
			root = root.next;
			return true;
		}
		Node curr = root;
		while (curr.next != null && (!curr.next.data.equals(o)))
			curr = curr.next;
		if (curr.next == null)
			return false;
		curr.next = curr.next.next;
		size--;

		return true;

	}

	@Override
	public void clear() {
		root = null;
		size = 0;

	}

	@Override
	public T get(int index) {

		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		int count = 0;
		node = root;
		while (count < index) {
			node = node.getNext();
			count++;
		}

		return (T) node.getData();
	}

	@Override

	public T set(int index, T element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node deleted = root;
		int count = 0;

		while (deleted != null && count <= index) {
			Node newNode = new Node(element);
			newNode = deleted;

		}
		return (T) deleted;

	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node temp = root;
		int count = 0;

		while (temp != null && ++count != index) {
			temp = temp.next;
			Node node = new Node(element);
			node.next = temp.next;
			temp.next = node;
		}
	}

	@Override

	public T remove(int index) {

		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			Node temp = root;
			root = root.next;
			return (T) temp.data;
		}

		int i = 0;
		Node current = root;
		while (i < index - 1) {
			i++;
			current = current.next;
		}
		Node t = current.next;
		current.next = current.next.next;
		size--;

		return (T) t.data;
	}

	@Override
	public int indexOf(Object o) {

		int count = 0;
		Node current = root;

		while (count <= size) {

			if (current.getNext().equals(o)) {
				current = current.next;
				return count;
			}
			count++;
		}
		return -1;
	}

	/**
	 * Iterator for CustomLinkedList
	 */
	private class CustomLinkedListIterator<E> implements Iterator<E> {

		Node actual = root;

		@Override
		public boolean hasNext() {

			return actual != null;

		}

		@Override
		public E next() {
			if (actual == null) {
				actual = root;
				return (E) actual.data;
			}
			if (root.next == null) {
				throw new NoSuchElementException();
			}
			root = root.next;
			return (E) root.data;
		}
	}

	@Override
	public void remove() {
		boolean removed = false;
		int prev = -1;

		if (!removed) {
			throw new IllegalStateException();
		}
		CustomLinkedList.this.remove(prev);
		removed = false;
	}

}
