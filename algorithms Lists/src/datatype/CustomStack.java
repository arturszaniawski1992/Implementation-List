package datatype;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import datastructure.list.CustomArrayList;
import datastructure.list.CustomLinkedList;

/**
 * @author ASZANIAW Stack, LIFO queue
 */
public class CustomStack<T> extends AbstractCustomStackAdapter<T> {

	List<T> storage = null;
	private int size;

	public CustomStack(List<T> storage) {

		this.storage = new CustomArrayList<>();
		for (int i = 0; i < storage.size(); i++) {
			this.storage.get(i);

		}

	}

	@Override
	public void push(T t) {

		storage.add(t);

	}

	@Override

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T element = storage.get(size() - 1);
		storage.remove(size() - 1);
		return element;
	}

	@Override
	public int size() {
		return storage.size();
	}

	@Override
	public boolean isEmpty() {
		return storage.size() == 0;
	}
}
