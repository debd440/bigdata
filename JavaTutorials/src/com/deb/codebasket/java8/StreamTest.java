package com.deb.codebasket.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {

		System.out.println("Example 1: Creating Stream");
		Stream<Integer> stream = Stream.of(1, 2, 3, 4);
		stream.forEach(p -> System.out.println(p));

		System.out.println("Example 2: List as Stream");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 3; i++) {
			list.add(i);
		}
		list.stream().forEach(p -> System.out.println(p));

		System.out.println("**************************Core Operation Start*****************************");
		System.out.println("Example 3: Filter- Stream Operation");
		List<String> students = new ArrayList<>();
		students.add("Ajay");
		students.add("Sunil");
		students.add("Anil");
		students.add("Swati");
		students.add("Lokesh");
		Stream<String> result = students.stream().filter(name -> name.startsWith("A"));
		result.forEach(System.out::println);

		System.out.println("Example 4: Map- Stream Operation");
		// result.map(item -> item.toUpperCase()).forEach(System.out::println); //Stream
		// Already Closed Error
		Stream<String> data = students.stream().filter(name -> name.startsWith("A"));
		data.map(item -> item.toUpperCase()).forEach(System.out::println);

		System.out.println("Example 5: Sort Operation- Stream Operation");
		students.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

		System.out.println("**************************Terminal Operation Start*****************************");
		System.out.println("Example 6: Count Records- Stream Operation");
		long count = students.stream().filter(name -> name.startsWith("A")).count();
		System.out.println("No of Elements: " + count);

		System.out.println("Example 7: Convert Stream into Collection");
		List<String> studentList = students.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
		studentList.forEach(System.out::println);

		System.out.println("Example 8: Match Records- Stream Operation");
		boolean matchedResult = students.stream().anyMatch(s -> s.startsWith("A"));
		System.out.println("Any Match Result: " + matchedResult);
		matchedResult = students.stream().allMatch(s -> s.startsWith("A"));
		System.out.println("All Match Result: " + matchedResult);
		matchedResult = students.stream().noneMatch(s -> s.startsWith("A"));
		System.out.println("None Match Result: " + matchedResult);

		System.out.println("Example 9: Find First Records- Stream Operation");
		String firstMatchedName = students.stream().filter((s) -> s.startsWith("A")).findFirst().get();
		System.out.println("The First Record: " + firstMatchedName);

		System.out.println("**************************Boxed Stream*****************************");
		List<String> strings = Stream.of("Scala", "Java", "Hadoop", "HBase", "Play").collect(Collectors.toList());
		System.out.println(strings);
		// IntStream.of(1, 2, 3, 4, 5).collect(Collectors.toList()); //Compliation Issue
		// for Primitive
		List<Integer> ints = IntStream.of(1, 2, 3, 4, 5).boxed().collect(Collectors.toList());
		System.out.println(ints);

	}
}
