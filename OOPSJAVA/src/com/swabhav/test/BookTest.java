package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.Book;
import com.swabhav.model.CricketPlayer;

public class BookTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Book books[] = new Book[3];
		for (int i = 0; i < books.length; i++) {

			System.out.println("Enter the Book Id : ");
			int bookId = scanner.nextInt();
			System.out.println("Enter the Book name : ");
			String name = scanner.next();
			System.out.println("Enter the Author name : ");
			String author = scanner.next();
			System.out.println("Enter the Book price : ");
			double price = scanner.nextDouble();
			System.out.println("Enter the Publciation Details : ");
			String publication = scanner.next();
			books[i] = new Book(bookId, name, author, price, publication);
		}

		for (int i = 0; i < books.length; i++) {

			System.out.println("Book ID is : " + books[i].getBookId());
			System.out.println("Book Name is : " + books[i].getName());
			System.out.println("Book Author is : " + books[i].getAuthor());
			System.out.println("Book Price is : " + books[i].getPrice());
			System.out.println("Book Publication is : " + books[i].getPublication());

		}
		for (int i=0; i<books.length-1; i++) {
			for (int j=i+1; j<books.length; j++) {
				if (books[i].getPrice() < books[j].getPrice()) {
				    Book temp = books[i];
				    books[i] = books[j];
				    books[j] = temp;
				}
			}
		}
		
		for (int i=0; i<books.length; i++) {
			System.out.println(books[i].getBookId()+ " " + books[i].getName()+ " ");
		}
		scanner.close();
	}
}
