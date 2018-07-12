package datastructure.list;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * Filter iterator
 * 
 * @author ASZANIAW
 */
public class FilterIterator<T> implements Iterator<T> {

	private T object;
	private final Predicate<T> predicate;
	private final Iterator<T> iterator;

	public FilterIterator(List<T> list, Predicate<T> predicate) {
		this.iterator = list.iterator();
		this.predicate = predicate;
	}

	// METODA POMOCNICZA
	public boolean find() {
		while (iterator.hasNext()) {
			T nextObj = iterator.next();
			if (predicate.test(nextObj)) {
				object = nextObj;
				return true;
			}

		}
		return false;

	}

	@Override
	public boolean hasNext() {

		if (iterator.hasNext() && find()) {
			return true;
		}
		return false;

	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		} else {
			return object;
		}

	}

	@Override

	public void remove() {
		if (!hasNext()) {
			throw new IllegalStateException();
		} else
			iterator.remove();

	}
}
