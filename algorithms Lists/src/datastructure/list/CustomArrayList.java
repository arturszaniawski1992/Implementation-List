package datastructure.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * List based on the table
 * 
 * @author ASZANIAW
 * @param <T>
 */

// zmiana o stala wartosc a nie o procentowa OK

public class CustomArrayList<T> extends AbstractCustomListAdapter<T> {

	int size;
	private final int CAPACITY = 10;
	private T[] elements;

	public CustomArrayList() {
		elements = (T[]) new Object[CAPACITY];
	}

	public CustomArrayList(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException();

		elements = (T[]) new Object[initialCapacity];

	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return true;
			}
		}

		return false;
	}

	@Override

	public Iterator<T> iterator() {

		return new CustomArrayListIterator<>();

	}

	/**
	 * // zmiana rozmiaru listy private void checkSizeofArrayList() { double
	 * fill = (double) size / elements.length + 1; double shrink = 0.90; double
	 * expand = 1.10; if (fill < 0.6) { changeSizeOfArrayList(shrink); } else if
	 * (fill > 0.9) { changeSizeOfArrayList(expand); } }
	 * 
	 * // metody do zwiekszania i zmniejszania pojemnosci private void
	 * changeSizeOfArrayList(double changeSize) { Object[] newArrayList = new
	 * Object[(int) (changeSize * elements.length)]; for (int index = 0; index <
	 * size; index++) { newArrayList[index] = elements[index]; }
	 * 
	 * elements = (T[]) newArrayList; }
	 * 
	 */
	// ZMIANA ROZMIARU TABLICY DODAWANIE
	public void increaseSize() {
		if (size / elements.length + 1 > 0.90)
			elements = Arrays.copyOf(elements, elements.length + 2);

	}

	public int getLenght() {
		return elements.length;
	}

	// ZMIANA ROZMIARU TABLICY USUWANIE
	public void decreaseSize() {
		if (size / elements.length + 1 < 0.60)
			elements = Arrays.copyOf(elements, elements.length - 2);

	}

	@Override
	public boolean add(T t) {
		increaseSize();
		elements[size] = t;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		decreaseSize();

		{
			if (size == 0)
				return false;
			int i = 0;
			while (i < size && (!elements[i].equals(o)))
				i++;
			if (i == size)
				return false;
			if (i == size - 1) {
				elements[i] = null;
				size--;
				return true;
			}
			for (int j = i; j < size - 1; j++) {

				elements[j] = elements[j + 1];
			}
			elements[size - 1] = null;
			size--;
			return true;

		}
	}

	@Override
	public void clear() {

		this.elements = (T[]) new CustomArrayList[CAPACITY];
		size = 0;

	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		return (T) elements[index];
	}

	@Override
	public T set(int index, T element) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		T current = get(index);
		elements[index] = element;
		return current;

	}

	@Override
	public void add(int index, T element) {
		increaseSize();

		for (int count = size; count > index; count--) {
			elements[count] = elements[count - 1];
		}
		size++;
		elements[index] = element;
	}

	@Override
	public T remove(int index) {
		decreaseSize();

		if (index < size) {
			Object object = elements[index];
			int temp = index;
			elements[index] = null;
			while (temp < size) {
				elements[temp] = elements[temp + 1];
				elements[temp + 1] = null;
				temp++;
			}
			size--;
			return (T) object;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Iterator for CustomArrayList
	 */

	private class CustomArrayListIterator<E> implements Iterator<E> {

		private int actual = 0;

		@Override
		public boolean hasNext() {
			return actual + 1 < size();

		}

		// nie zwraca prawidlowo ostaniego elementu
		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			// zmiana o wyrzucenie wartosci na indeks wyzszej
			return (E) elements[actual++];

		}

		@Override
		public void remove() {

			CustomArrayList.this.remove(--actual);

		}
	}
}
