package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.IncludeCategories;

import datastructure.list.CustomLinkedList;

public class CustomLinkedListTest {

	@Test
	public void checkLinkedList() {
		CustomLinkedList<Integer> numbers = new CustomLinkedList<>();
		numbers.add(2);
		numbers.add(134);
		numbers.add(145);
		numbers.add(11);

		assertEquals(4, numbers.size());
		assertTrue(numbers.add(10));

	}

	@Test
	public void addToLinkedList() {
		CustomLinkedList<Integer> numbers = new CustomLinkedList<>();
		numbers.add(2);
		numbers.add(134);
		numbers.add(145);
		numbers.add(11);

		assertTrue(numbers.remove(new Integer(2)));

	}

	@Test
	public void isInLinkedList() {

		CustomLinkedList<Integer> numbers = new CustomLinkedList<>();
		numbers.add(2);
		numbers.add(134);
		numbers.add(145);
		numbers.add(11);

		assertTrue(numbers.contains(new Integer(2)));
		assertFalse(numbers.contains(new Integer(1233)));
		assertFalse(numbers.contains(new Integer(11244)));
		assertTrue(numbers.contains(new Integer(134)));

	}

	@Test
	public void removeFromLinkedList() {

		CustomLinkedList<Integer> numbers = new CustomLinkedList<>();
		numbers.add(2);
		numbers.add(134);
		numbers.add(145);
		numbers.add(11);

		assertTrue(numbers.remove(new Integer(2)));
		assertEquals(new Integer(145), numbers.remove(1));
		assertEquals(new Integer(134), numbers.remove(0));

	}

	@Test
	public void indexOfInLinkedList() {
		CustomLinkedList<Integer> numbers = new CustomLinkedList<>();
		numbers.add(2);
		numbers.add(134);
		numbers.add(145);
		numbers.add(11);

		assertEquals(0, numbers.indexOf(new Integer(2)));
		assertEquals(1, numbers.indexOf(new Integer(134)));

	}

}
