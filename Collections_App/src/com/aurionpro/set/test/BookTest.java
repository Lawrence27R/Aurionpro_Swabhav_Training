package com.aurionpro.set.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.set.model.Book;
import com.aurionpro.set.model.ComparatorClassBook;

public class BookTest {
	public static void main(String[] args) {
		List<Book> books = inputBooks();
		printBooks(books);

		System.out.println();
		Collections.sort(books, new ComparatorClassBook.BookComplexComparator1());
		System.out.println("Sorted by Author, then Title, then Price:");
		printBooks(books);
		System.out.println();
		Collections.sort(books, new ComparatorClassBook.BookComplexComparator2());
		System.out.println("Sorted by Publication Year, then Price, then Author:");
		printBooks(books);
	}

	private static List<Book> inputBooks() {
		List<Book> books = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of books: ");
		int number = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < number; i++) {
			System.out.println("For Book " + (i + 1) + " : ");
			System.out.println("Enter Book Title: ");
			String title = scanner.nextLine();
			System.out.println("Enter Book Author Name: ");
			String author = scanner.nextLine();
			System.out.println("Enter the Book Price: ");
			double price = scanner.nextDouble();
			System.out.println("Enter the Year of Publication: ");
			int publicationYear = scanner.nextInt();
			scanner.nextLine();

			books.add(new Book(title, author, price, publicationYear));
		}
		scanner.close();
		return books;
	}

	private static void printBooks(List<Book> books) {
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
