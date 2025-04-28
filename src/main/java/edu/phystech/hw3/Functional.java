package edu.phystech.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Functional {
	public static <T, R> List<R> map(List<? extends T> list,
		Function<? super T, ? extends R> mapper) {
		var result = new ArrayList<R>(list.size());
		for (var item : list) {
			result.add(mapper.apply(item));
		}
		return result;
	}

	public static <T> T reduce(List<T> list, BinaryOperator<T> reducer, T seed) {
		var accumulator = seed;
		for (var element : list) {
			accumulator = reducer.apply(accumulator, element);
		}
		return accumulator;
	}
}