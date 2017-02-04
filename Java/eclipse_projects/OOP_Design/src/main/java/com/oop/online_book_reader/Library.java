package com.oop.online_book_reader;

import java.util.HashMap;

public class Library {

	HashMap<Integer, Book> books;

	public Library() {
		books = new HashMap<>();
	}

	public void addBook(Book b) {
		books.put(b.getBookId(), b);
	}

	public void removeBook(Book b) {
		removeBook(b.getBookId());
	}

	public void removeBook(Integer bookId) {
		books.remove(bookId);
	}

	public Book find(int id) {
		return books.get(id);
	}

}
