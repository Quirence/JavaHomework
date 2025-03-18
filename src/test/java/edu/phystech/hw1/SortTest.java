package edu.phystech.hw1;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SortTest {

	private static boolean isSorted(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				return false;
			}
		}
		return true;
	}

	private static int[] sort(int[] nums) {
		int[] sortedArray = Arrays.copyOf(nums, nums.length);
		Random rand = new Random();
		while (!isSorted(sortedArray)) {
			for (int i = 0; i < sortedArray.length; i++) {
				int j = rand.nextInt(sortedArray.length);
				int temp = sortedArray[i];
				sortedArray[i] = sortedArray[j];
				sortedArray[j] = temp;
			}
		}
		return sortedArray;
	}
	// Передаю привет своему преподавателю алгоритмов

	@Test public void sortWorks() {
		Assertions.assertArrayEquals(new int[] {1}, sort(new int[] {1}));
		Assertions.assertArrayEquals(new int[] {1, 2, 3, 4, 5}, sort(new int[] {5, 4, 3, 2, 1}));
	}

	@Test public void sortReturnsNewArray() {
		int[] input = {9, 1, 3, 11, 45, 499};
		int[] copy = Arrays.copyOf(input, input.length);

		int[] sorted = sort(input);

		Assertions.assertArrayEquals(new int[] {1, 3, 9, 11, 45, 499}, sorted);
		Assertions.assertArrayEquals(copy, input);
	}
}
