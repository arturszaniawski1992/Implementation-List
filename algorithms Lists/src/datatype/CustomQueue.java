package datatype;

import java.util.List;
import java.util.NoSuchElementException;

import datastructure.list.CustomArrayList;

/**
 * @author ASZANIAW FIFO queue
 */
public class CustomQueue<T> extends AbstractCustomQueueAdapter<T> {

	List<T> storage = null;
	private int size;

	public CustomQueue(List<T> storage) {

		this.storage = new CustomArrayList<>();
		for (int i = 0; i < storage.size(); i++) {
			this.storage.get(i);

		}

	}

	@Override
	public int size() {
		return storage.size();
	}

	@Override
	public boolean isEmpty() {
		return storage.size() == 0;
	}

	@Override
	public boolean add(T t) {
		return storage.add(t);

	}

	@Override

	public T poll() {
		if (isEmpty()) {
			return null;
		}
		T element = storage.get(0);
		storage.remove(0);
		return element;
	}

	@Override

	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return storage.get(0);
	}
}
