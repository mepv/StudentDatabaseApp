package com.udemy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Student student = new Student();
	    while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Add a new Student. For Quit press Q.");

	    	if (!scanner.nextLine().equals("Q")) {
				System.out.println("Enter student first name: ");
				String firstName = scanner.nextLine();
				System.out.println("Enter student last name: ");
				String lastName = scanner.nextLine();
				student.addStudent(firstName, lastName);
				student.enroll();
				student.payTuition();

	    	} else {
	    		break;
			}
		}
		student.showInfo();
    }
}
