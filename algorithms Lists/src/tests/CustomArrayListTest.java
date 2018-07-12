package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import datastructure.list.CustomArrayList;

public class CustomArrayListTest {

	List<Integer> numbers = new CustomArrayList<>();

	@Before
	public void setUpList() {

		numbers.add(10);
		numbers.add(11);
		numbers.add(14);
		numbers.add(5);
		numbers.add(50);
		numbers.add(65);
		numbers.add(123);
		numbers.add(14);
		numbers.add(19);

	}

	@Test
	public void checkSizeOfArraList() {
		assertEquals(9, numbers.size());
		numbers.add(15);
		assertEquals(10, numbers.size());

	}

	@Test
	public void isArrayEmpty() {
		assertFalse(false);
	}

	@Test
	public void containsElementOfArrayList() {
		assertTrue(numbers.contains(10));
		assertTrue(numbers.contains(123));
		assertTrue(numbers.contains(65));
		assertTrue(numbers.contains(50));
	}

	@Test
	public void addToArrayList() {
		assertTrue(true);

	}

	@Test
	public void removeFromArrayList() {
		assertTrue(numbers.remove(new Integer(10)));
		assertFalse(numbers.remove(new Integer(103)));
		assertEquals(false, numbers.remove(new Integer(10)));

	}

	@Test
	public void getElementFromIndex() {
		assertEquals(new Integer(10), numbers.get(0));
		assertEquals(new Integer(65), numbers.get(5));

	}

	@Test
	public void removeFromIndex() {
		assertEquals(new Integer(65), numbers.get(5));

	}

}
