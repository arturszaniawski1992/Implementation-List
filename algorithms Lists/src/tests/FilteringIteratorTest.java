package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.list.CustomArrayList;
import datastructure.list.FilterIterator;

public class FilteringIteratorTest {

	@Test
	public void testIterator() {
		CustomArrayList<Integer> numbers = new CustomArrayList<>();
		numbers.add(10);
		numbers.add(21);
		numbers.add(4);
		numbers.add(7);

		FilterIterator<Integer> iteratorFilter = new FilterIterator<>(numbers, x -> x < 10);
		FilterIterator<Integer> iteratorFilter2 = new FilterIterator<>(numbers, x -> x > 35);

		assertEquals(true, iteratorFilter.hasNext());
		assertEquals(false, iteratorFilter2.hasNext());

	}

	@Test
	public void removeObject() {
		CustomArrayList<Integer> numbers = new CustomArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);

		numbers.remove();

		FilterIterator<Integer> iteratorFilter = new FilterIterator<>(numbers, x -> x < 10);
		FilterIterator<Integer> iteratorFilter2 = new FilterIterator<>(numbers, x -> x > 35);

		assertEquals(true, iteratorFilter.hasNext());
		assertEquals(false, iteratorFilter2.hasNext());
	}

}
