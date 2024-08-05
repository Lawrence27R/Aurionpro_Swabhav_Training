package com.aurionpro.set.model;

import java.util.Comparator;

public class ComparatorClassBook {

    public static class BookTitleComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.getTitle().compareTo(book2.getTitle());
        }
    }

    public static class BookAuthorComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.getAuthor().compareTo(book2.getAuthor());
        }
    }

    public static class BookPriceComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return Double.compare(book1.getPrice(), book2.getPrice());
        }
    }

    public static class BookPublicationYearComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return Integer.compare(book2.getPublicationYear(), book1.getPublicationYear());
        }
    }

    public static class BookComplexComparator1 implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return Comparator.comparing(Book::getAuthor)
                             .thenComparing(Book::getTitle)
                             .thenComparing(Book::getPrice)
                             .compare(book1, book2);
        }
    }

    public static class BookComplexComparator2 implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return Comparator.comparing(Book::getPublicationYear).reversed()
                             .thenComparing(Book::getPrice)
                             .thenComparing(Book::getAuthor)
                             .compare(book1, book2);
        }
    }
}
