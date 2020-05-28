package com.ildar.bookapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookAppApplicationTests {

	@Autowired
	private BookService bookService;

	@Test
	public void testBookCountUnique() {
		Random random = new Random();
		List<Book> books = Stream.generate(() -> new Book(String.valueOf(random.nextLong())))
				.limit(1000)
				.collect(Collectors.toList());

		books.parallelStream()
				.forEach(bookService::saveBook);

		List<Book> dbBooks = bookService.getBooks();
		Set<Long> uniqueBookCount = dbBooks.stream()
				.map(Book::previousBookCount)
				.collect(Collectors.toSet());

		assertEquals(uniqueBookCount.size(), dbBooks.size());
		assertTrue(uniqueBookCount.contains(0L));
		assertFalse(uniqueBookCount.contains(1000L));
	}
}
