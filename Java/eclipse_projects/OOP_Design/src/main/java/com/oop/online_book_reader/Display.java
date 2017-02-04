package com.oop.online_book_reader;

public class Display {

	private Book activeBook;
	private User activeUser;
	private int pageNumber = 0;
	public Book getActiveBook() {
		return activeBook;
	}
	public void setActiveBook(Book activeBook) {
		this.activeBook = activeBook;
	}
	public User getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}
	
	public void turnPageForward(){
		pageNumber++;
	}
	
	public void turnPageBackward(){
		pageNumber--;
	}
	
	
}
