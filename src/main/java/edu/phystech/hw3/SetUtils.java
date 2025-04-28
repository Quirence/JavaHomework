package edu.phystech.hw3;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {
	public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
		Set<E> union_set = new HashSet<>(s1);
		union_set.addAll(s2);
		return union_set;
	}

	public static <E> Set<E> intersection(Set<? extends E> s1, Set<? extends E> s2) {
		Set<E> intersection_set = new HashSet<>(s1);
		intersection_set.retainAll(s2);
		return intersection_set;
	}

	public static <E> Set<E> difference(Set<? extends E> s1, Set<? extends E> s2) {
		Set<E> difference_set = new HashSet<>(s1);
		difference_set.removeAll(s2);
		return difference_set;
	}

	public static <E> Set<E> symmetricDifference(Set<? extends E> s1, Set<? extends E> s2) {
		return union(difference(s1, s2), difference(s2, s1));
	}
}