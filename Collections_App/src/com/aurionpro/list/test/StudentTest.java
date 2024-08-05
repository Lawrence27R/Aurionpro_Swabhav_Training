package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.aurionpro.list.model.Student;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Percentage: ");
            double percentage = scanner.nextInt();
            scanner.nextLine(); 

            students.add(new Student(studentId, name, percentage));
        }

        System.out.println("Using normal for loop");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        System.out.println("Using advanced for loop");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("Using Iterator");
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }

        System.out.println("Using List iterator");
        ListIterator<Student> studentListIterator = students.listIterator();

        // Iterate forwards
        while (studentListIterator.hasNext()) {
            System.out.println(studentListIterator.next());
        }

        // Iterate backwards
        System.out.println("Iterating backwards");
        while (studentListIterator.hasPrevious()) {
            System.out.println(studentListIterator.previous());
        }

        scanner.close();
    }
}
